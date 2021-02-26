package com.codingdojo.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		
		SimpleDateFormat ft = new SimpleDateFormat ("EEEEE ', the' dd 'of' MMMMM ',' yyyy");
			
		model.addAttribute("date", ft.format(date));
		
		return "date.jsp";
	}

	@RequestMapping("/time")
	public String time(Model model) {
		Date time = new Date();
		
		SimpleDateFormat ft = new SimpleDateFormat ("hh:mm a");
		
		model.addAttribute("time", ft.format(time));

		return "time.jsp";
	}

}
