package com.codingdojo.web.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.codingdojo.web.models.Dojo;
import com.codingdojo.web.models.Ninja;
import com.codingdojo.web.services.DojoService;
import com.codingdojo.web.services.NinjaService;

@Controller
public class DojoControllers {
		
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoControllers(DojoService dojoService,  NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	
	@GetMapping("/dojo/new")
	public String indexDojo( @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		return "formDojo.jsp";
	}
	
	@RequestMapping(value="/dojo/new", method= RequestMethod.POST)
	public String indexDojoPost(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "formDojo.jsp";
		}
		else {
			dojoService.save(dojo);
			return "redirect:/dojo/new";
		}
		
		
	}
	
	@GetMapping("/dojo/{id}")
	public String indexDojoId(@PathVariable("id") Long id, Model model) {
		
		List<Dojo> dojos = dojoService.findDojoById(id);
		model.addAttribute("dojos", dojos);

		
		List<Ninja> ninjas = ninjaService.findDojoById(id);
		model.addAttribute("ninjas", ninjas);
		
		return "showDojoId.jsp";
		
	}
	
	
	/* 
	 * @RequestMapping(value = "/licenses/new" , method=RequestMethod.GET)
	public String index( @ModelAttribute("licenses") License license, BindingResult result, Model model) {
			
     
			List<Person> personas = personServices.findAllPersons();
			
			model.addAttribute("personas", personas);
			
			return "newlicense.jsp";	
	}
	
	@RequestMapping(value = "/licenses/new" , method=RequestMethod.POST)
	public String indexPost(@Valid @ModelAttribute("licenses") License license, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		
		List<Person> personas = personServices.findAllPersons();
		model.addAttribute("personas", personas);
		
		if (result.hasErrors()) {
			model.addAttribute("msg", result);
			return "newlicense.jsp";
		}
		else {
			  
			if (licenseServices.findPerson(license.getPerson())!=false) {
				licenseServices.createlicense(license);
				redirectAttributes.addFlashAttribute("msg", "Creado");
				return "redirect:/licenses/new";
			}
			else
			{
				redirectAttributes.addFlashAttribute("msg", "Ya tiene una Licencia");
				return "redirect:/licenses/new";
			}
			
			
		}
		
		
		
	}
	 * 
	 * 
	 */
}
