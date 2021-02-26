package com.codingdojo.web.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(Model model) {
		ArrayList<String> language = new ArrayList<String>();
		language.add("Java");
		language.add("C++");
		language.add("C#");
		language.add("Python");
		
		model.addAttribute("language",language);
		
		ArrayList<String> location = new ArrayList<String>();
		location.add("Arica");
		location.add("Valparaíso");
		location.add("Concepción");
		location.add("Santiago");
		
		model.addAttribute("location",location);
		
		return "index.jsp";
	}
	
	@RequestMapping(value="/result", method = RequestMethod.POST)
	public String result(Model model, @RequestParam(value="name") String name,
			@RequestParam(value="location") String location,
			@RequestParam(value="language") String language,
			@RequestParam(value="comment") String comment) {
		
		if (name.equals(null) || name.equals("") ) {  return "redirect:/errorAtt"; } 
		
		
		model.addAttribute("name",name);
		model.addAttribute("location",location);
		
		model.addAttribute("language",language);
		model.addAttribute("comment",comment);
		
		
		
		if (language.equals("Java")) {
			return "favorite.jsp";
		}
		
		return "result.jsp";
	}
	
	@RequestMapping("/errorAtt")
	public String error(RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("error", "You must fill the field \"name\"");
	
		return "redirect:/";
		
	}
}
