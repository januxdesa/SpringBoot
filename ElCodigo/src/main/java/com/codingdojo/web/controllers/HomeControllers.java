package com.codingdojo.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeControllers {

	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("pass", "bushido");
	
		return "index.jsp";
		
	}
	
	@RequestMapping(value="/code", method=RequestMethod.POST)
	 public String login(@RequestParam(value="password") String password,HttpSession session) {
		
		if  (password.equals(session.getAttribute("pass"))) {
			
			return "code.jsp";
			
		
		}
		return "redirect:/errorPass";
	}
	
	@RequestMapping("/errorPass")
	public String errorPass(RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
	
		return "redirect:/";
		
	}
	
	
	
	 
	
}
