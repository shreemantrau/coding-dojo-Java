package com.codingdojo.test.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.test.models.Event;
import com.codingdojo.test.models.Message;
import com.codingdojo.test.models.User;
import com.codingdojo.test.repositories.UserRepository;
import com.codingdojo.test.repositories.eventRepository;
import com.codingdojo.test.repositories.messageRepository;

@Service
public class ApplicationService {
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private eventRepository er;
    
	@Autowired 
	private messageRepository mr;
//	
//	@Autowired
	
	
	public boolean duplicateUser(String email) {
        User user = ur.findByEmail(email);
        if(user == null) {
            return false;
        }
        else {
        	return true;
        }
    }
	
	
	
	public User registerUser(User user) {
		
		 String hashedpasswd = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
	        user.setPassword(hashedpasswd);
	        return ur.save(user);				
		
	}



	public boolean validateLogin(String email, String passwd) {
		User u= ur.findByEmail(email);
		if(u==null)return false;
		
		if(!BCrypt.checkpw(passwd, u.getPassword())) {
			return false;
		}
			
		
		return true;
	}



	public User getEmail(String email) {
		return ur.findByEmail(email);
	}
	
	
	
	public User findUser(Long id) {
		Optional<User> u = ur.findById(id);
    	if(u.isPresent()) {
            return u.get();
    	}
    	else {
    	    return null;
    	}
	}



	public List<Event> getEvents() {
		List<Event> list= (List<Event>) er.findAll();
		return list;
	}



	public void createEvent(Event event) {
		// TODO Auto-generated method stub
		er.save(event);
	}



	public Event getEvent(Long id) {
		// TODO Auto-generated method stub
		return er.findById(id).get();
	}



	public void addMessage(Message message) {
		
		
		mr.save(message);
	}
	
	public void updateEvent(Event event) {
		er.save(event);
	}



	public void deleteEvent(Long id) {
		er.deleteById(id);
		
	}
}
