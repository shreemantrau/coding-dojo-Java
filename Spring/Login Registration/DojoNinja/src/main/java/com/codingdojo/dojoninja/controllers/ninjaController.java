package com.codingdojo.dojoninja.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojoninja.models.Ninja;
import com.codingdojo.dojoninja.services.dnService;

@Controller
public class ninjaController {
	
	
	
	private final dnService dns;
	public ninjaController(dnService dns) {
		this.dns=dns;
	}
	
	@RequestMapping("/ninjas/new")
	public String index(@Valid @ModelAttribute("ninjas") Ninja ninja, Model model) {
		model.addAttribute("dojos",dns.getDojos());   
		dns.createNinja(ninja);
		return "newNinja.jsp";
	}
	
	 	
}
