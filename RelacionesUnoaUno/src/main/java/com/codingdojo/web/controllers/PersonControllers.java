package com.codingdojo.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.web.models.Person;
import com.codingdojo.web.services.LicenseServices;
import com.codingdojo.web.services.PersonServices;

@Controller

public class PersonControllers {

	private final PersonServices personServices;
	private final LicenseServices licenseServices;
	
	
	public PersonControllers( PersonServices personServices,LicenseServices licenseServices) {
		this.licenseServices = licenseServices;	
		this.personServices = personServices;
	}
	
	
	@RequestMapping(value = "/persons/new" , method=RequestMethod.GET)
	public String index( @ModelAttribute("persons") Person person, BindingResult result, Model model) {
		
			return "newperson.jsp";	
	}
	
	@RequestMapping(value = "/persons/new" , method=RequestMethod.POST)
	public String indexPost(@Valid @ModelAttribute("persons") Person person, BindingResult result, Model model) {
		
		if (result.hasErrors())
			return "newperson.jsp";
		else {
			personServices.createperson(person);
			return "redirect:/persons/new";
		}
		
	}

	@RequestMapping(value = "/persons/{id}")
	public String indexPerson(@PathVariable("id") Long id, Model model) {
		
		
		
		Person person = personServices.findPerson(id);
		
		
		model.addAttribute("name", person.getFirstName() + " " +person.getLastName());
		model.addAttribute("license", person.getLicense().getNumber());
		model.addAttribute("state", person.getLicense().getState());
				
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String expire = sdf.format(person.getLicense().getExpirationDate());
		model.addAttribute("expire", expire);
		
		return "person.jsp";
		
	}
	
	
}
