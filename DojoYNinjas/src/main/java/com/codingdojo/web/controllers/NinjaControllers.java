package com.codingdojo.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.web.models.Dojo;
import com.codingdojo.web.models.Ninja;
import com.codingdojo.web.services.DojoService;
import com.codingdojo.web.services.NinjaService;

@Controller
public class NinjaControllers {
	
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjaControllers(NinjaService ninjaService,  DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}

	@GetMapping("/ninja/new")
	public String indexNinja( @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		
		model.addAttribute("dojos", dojoService.findAll());
		//List<Dojo> test = dojoService.findAll();
		
		
		return "formNinja.jsp";
	}
	
	@RequestMapping(value="/ninja/new", method= RequestMethod.POST)
	public String indexNinjaPost(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "formNinja.jsp";
		}
		else {
			ninjaService.save(ninja);
			return "redirect:/ninja/new";
		}
		
		
		
	}
}
