package com.codingdojo.dojoninja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojoninja.models.Dojo;
import com.codingdojo.dojoninja.models.Ninja;
import com.codingdojo.dojoninja.services.dnService;

@Controller
public class dojoController {
	private final dnService dns;
	
	dojoController(dnService dns){
		this.dns=dns;
	}
	
	
	@RequestMapping("/dojos/{id}")
	public String showDojos(@PathVariable("id")Long id, Model model) {
	
//		List<Dojo>list=(dns.showAllDojos(id));
//		System.out.println(dns.showAllDojos(id));
		System.out.println(dns.getThatDojo(id));
		
		//List<Dojo> l=dns.getThatDojo(id);
		
		model.addAttribute("dojo",dns.getThatDojo(id).get());
//		List<Ninja> ninjas = dns.getDojo(id).getNinjas();
		model.addAttribute("ninjas",dns.findAllNinjasByDojoId(id));

		
		return "display.jsp";
	}
	
	@RequestMapping("/")
	public String inex(@Valid @ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@RequestMapping("/createDojo")
	public String createNew(@Valid @ModelAttribute("dojo")  Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
//		return "";
		dns.createDojo(dojo);
		return"redirect:/";
	}
}
