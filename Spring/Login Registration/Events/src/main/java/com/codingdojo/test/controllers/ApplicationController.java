package com.codingdojo.test.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.test.models.Event;
import com.codingdojo.test.models.Message;
import com.codingdojo.test.models.User;
import com.codingdojo.test.repositories.eventRepository;
import com.codingdojo.test.services.ApplicationService;
import com.codingdojo.test.validators.UserValidator;



@Controller
public class ApplicationController {
	@Autowired
	private  ApplicationService as;
	@Autowired
	private  UserValidator userValidator;
	@Autowired
	private eventRepository er;
	
	
	ArrayList<String> states = new ArrayList<String>(Arrays.asList("AL", "AK", "AZ", "AR", "CA", "CO", "CT",
			"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN",
			"MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
			"SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"));
	
	//Index
	@GetMapping("/")
	public String index(@ModelAttribute("u") User user, Model model) {
		model.addAttribute("states", states);
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("u") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			model.addAttribute("states", states);
			return "index.jsp";
		}
		boolean isDuplicate = as.duplicateUser(user.getEmail());
		if(isDuplicate) {
			System.out.println("Inside duplicate!");
			model.addAttribute("error", "Email already in use! Please try again with a different email address!");
			return "index.jsp";
		}
		User u =as.registerUser(user);
		session.setAttribute("userId", u.getId());
		return "redirect:/events";
	}
	
	
	
	@PostMapping("/login")
	public String validateLogin(@RequestParam("email") String email, @RequestParam("password")String passwd,HttpSession session,Model model) {
		boolean valid= as.validateLogin(email,passwd);
		if(valid) {
			User u=as.getEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/events";
		}
		
		else {
			model.addAttribute("error","Credentials are invalid, please try again!");
			return "index.jsp";
		}
	}
	

	
	
	@RequestMapping("/events")
	public String event(@Valid @ModelAttribute("e") Event event, BindingResult result, HttpSession session, Model model) {
		
		if(session.getAttribute("userId")== null) {
			return "redirect:/";
		}
		session.setAttribute("states", states);
		User u=as.findUser((Long)session.getAttribute("userId"));
		model.addAttribute("user",u);
		
		List<Event> events=as.getEvents();
		List<Event> sameState=new ArrayList<>();
		List<Event> diffState= new ArrayList<>();
		
		for(Event traverse:events) {
			if(traverse.getState().equals(u.getState())){
				sameState.add(traverse);
			}
			else {
				diffState.add(traverse);
			}
		}
		
		model.addAttribute("sameState",sameState);
		model.addAttribute("diffState",diffState);
		
		
		
		return"dashboard.jsp";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"redirect:/";
	}
	
	
	@PostMapping("/createEvent")
	public String createEvent(@Valid @ModelAttribute("e")Event event, BindingResult result) {
		if(result.hasErrors()) {
			return"/dashboard.jsp";
		}
		
		as.createEvent(event);
		return "redirect:/events";
	}
	
	@RequestMapping("/events/{id}/edit")
	public String editEvent(@PathVariable("id")Long id,@ModelAttribute("eve") Event event, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
		return "redirect:/";
		}
		
		User user=as.findUser((Long)session.getAttribute("userId"));
		if(user.getId() == as.getEvent(id).getUser().getId()) {
			model.addAttribute("event",as.getEvent(id));
			return "editEvent.jsp";
		}
		
		return "redirect:/";	
	}
	
	@PutMapping("/events/{id}/edit")
	public String editEvent(@Valid @PathVariable("id") Long id, @ModelAttribute("eve") Event event, BindingResult result, Model model, HttpSession session) {
		User user = as.findUser((Long)session.getAttribute("userId"));
		if(as.getEvent(id).getUser().getId() == user.getId()) {
			if(result.hasErrors()) {
				model.addAttribute("event", as.getEvent(id));
				return "edit.jsp";
			}
			else {
				Event eventEdit = as.getEvent(id);
				model.addAttribute("event", eventEdit);
				model.addAttribute("user", user);
				event.setUser(user);
				event.setJoinedUsers(event.getJoinedUsers());
				as.createEvent(event);
				return "redirect:/events";
			}
		}
		else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/events/{id}")
	public String moreinfo( @Valid @ModelAttribute("m") Message message, BindingResult result, @PathVariable("id")Long id,Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		User user=as.findUser((Long) session.getAttribute("userId"));
		Event event = as.getEvent(id);
		List<Message>messages=event.getMessages();
		//Collections.reverse(messages);
		model.addAttribute("user",user);
		model.addAttribute("attendees", event.getJoinedUsers());
		model.addAttribute("messages", messages);
		model.addAttribute("event",event);
		return "moreinfo.jsp";
		
	
	}
	
	@PostMapping("/events/addmessage")
	public String addMessage(@Valid @ModelAttribute("m") Message message, BindingResult result,HttpSession session, Model model) {

		User user=as.findUser((Long)session.getAttribute("userId"));
		model.addAttribute("user",user);
		as.addMessage(message);
		return "redirect:/events";
	}
	
	
	@RequestMapping("/events/{id}/join")
	public String rsvp(@PathVariable("id") Long id, HttpSession session) {
		User user = as.findUser((Long) session.getAttribute("userId"));
		Event event=as.getEvent(id);
		System.out.println();
		List<User>attendees=event.getJoinedUsers();
		attendees.add(user);
		as.updateEvent(event);
		
		System.out.println("Howdy!!!!");
		return"redirect:/events";
	}
	
	@RequestMapping("/events/{id}/cancel")
	public String rsvp2(@PathVariable("id")Long id, HttpSession session) {
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		User user = as.findUser((Long) session.getAttribute("userId"));
		Event event=as.getEvent(id);
		System.out.println("User: "+user+" Event: "+event+" P Varaible: "+id);
		System.out.println(event.getJoinedUsers().get(0));
		List<User> attendees = event.getJoinedUsers();
		if(attendees.size()>0) {
		for(int i=0;i<attendees.size();i++) {
			if(attendees.get(i).getId() == user.getId()) {
				attendees.remove(i);
			}
		}
		}
		event.setJoinedUsers(attendees);
		as.createEvent(event);
		return"redirect:/events";
	}
	
	@RequestMapping("/events/{id}/delete")
	public String deleteEvent(@PathVariable("id")Long id) {
		Event event=as.getEvent(id);
		as.deleteEvent(id);
		return "redirect:/events";
	}

//	@GetMapping("/events/{id}")
//	public String viewEvent(@PathVariable("id") Long id, @Valid @ModelAttribute("messageObj") Message message, BindingResult result, Model model, HttpSession session) {
//		if(session.getAttribute("userId") == null) {
//			return "redirect:/";
//		}
//		User user = beltReviewerService.findUserById((Long) session.getAttribute("userId"));
//		Event event = beltReviewerService.findEventById(id);
//		List<Message> messages = event.getMessages();
//		Collections.reverse(messages);
//		model.addAttribute("event", event);
//		model.addAttribute("user", user);
//		model.addAttribute("attendees", event.getJoinedUsers());
//		model.addAttribute("messages", messages);
//		return "details.jsp";
//	}
//
//	@GetMapping("/events/{id}/edit")
//	public String editPage(@PathVariable("id") Long id, @ModelAttribute("event") Event event, Model model, HttpSession session) {
//		if(session.getAttribute("userId") == null) {
//			return "redirect:/";
//		}
//		User user = beltReviewerService.findUserById((Long)session.getAttribute("userId"));
//		if(beltReviewerService.findEventById(id).getUser().getId() == user.getId()) {
//			model.addAttribute("event", beltReviewerService.findEventById(id));
//			return "edit.jsp";
//		}
//		else {
//			return "redirect:/";
//		}
//	}
//

//	
//	//CRUD
//	@PostMapping("/addevent")
//	public String addEvent(@Valid @ModelAttribute("eventObj") Event event, BindingResult result, HttpSession session) {
//		if(result.hasErrors()) {
//			return "dashboard.jsp";
//		}
//		else {
//			beltReviewerService.addEvent(event);
//			return "redirect:/events";	
//		}	
//	}
//	
//	@PutMapping("/events/{id}/edit")
//	public String editEvent(@Valid @PathVariable("id") Long id, @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
//		User user = beltReviewerService.findUserById((Long)session.getAttribute("userId"));
//		if(beltReviewerService.findEventById(id).getUser().getId() == user.getId()) {
//			if(result.hasErrors()) {
//				model.addAttribute("event", beltReviewerService.findEventById(id));
//				return "edit.jsp";
//			}
//			else {
//				Event eventEdit = beltReviewerService.findEventById(id);
//				model.addAttribute("event", eventEdit);
//				model.addAttribute("user", user);
//				event.setUser(user);
//				event.setJoinedUsers(event.getJoinedUsers());
//				beltReviewerService.updateEvent(event);
//				return "redirect:/events";
//			}
//		}
//		else {
//			return "redirect:/";
//		}
//	}
//	
//	@RequestMapping("/events/{id}/join")
//	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
//		User user = beltReviewerService.findUserById((Long) session.getAttribute("userId"));
//		Event event = beltReviewerService.findEventById(id);
//		List<User> attendees = event.getJoinedUsers();
//		attendees.add(user);
//		event.setJoinedUsers(attendees);
//		beltReviewerService.updateUser(user);	
//		return "redirect:/events";
//	}
//	
//    @RequestMapping("/events/{id}/cancel")
//    public String cancelEvent(@PathVariable("id") Long id, HttpSession session) {
//    	User user = beltReviewerService.findUserById((Long) session.getAttribute("userId"));
//		Event event = beltReviewerService.findEventById(id);
//    	List<User> attendees = event.getJoinedUsers();
//        for(int i=0; i<attendees.size(); i++) {
//            if(attendees.get(i).getId() == user.getId()) {
//            	attendees.remove(i);
//            }
//        }
//        event.setJoinedUsers(attendees);
//        beltReviewerService.updateUser(user);
//    	return "redirect:/events";
//    }
//    
//    @RequestMapping("/events/{id}/delete")
//    public String delete(@PathVariable("id") Long id) {
//    	Event event = beltReviewerService.findEventById(id);
//    	for(User user: event.getJoinedUsers()) {
//    		List<Event> myevents = user.getJoinedevents();
//    		myevents.remove(event);
//    		user.setJoinedevents(myevents);;
//    		beltReviewerService.updateUser(user);
//    	}
//    	for(Message message: mServ.allMessages()) {
//    		if(message.getEvent() == event) {
//    			mServ.delete(message.getId());
//    		}
//    	}
//    	beltReviewerService.deleteEvent(id);
//    	return "redirect:/events";
//    }
//	
//	@PostMapping("events/addmsg")
//	public String addMessage(@ModelAttribute("messageObj") Message message, Model model, HttpSession session) {
//		User user = beltReviewerService.findUserById((Long) session.getAttribute("userId"));
//		model.addAttribute("user", user);
//		beltReviewerService.newMessage(message);
//		return "redirect:/events";
//		
//	}
}
