package com.codingdojo.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	
	@RequestMapping("/")
	public String index (HttpSession session){
	
		if (session.getAttribute("count")==null ) {
			session.setAttribute("count", 0);
			}
	        //Integer count = (Integer) session.getAttribute("count");
	        Integer count = (Integer) session.getAttribute("count");
			count += 1;
			session.setAttribute("count", count);
	        return "index.jsp";	
	}
	
	@RequestMapping("/acceso2")
	public String indexa (HttpSession session){
	
		if (session.getAttribute("count")==null ) {
			session.setAttribute("count", 0);
			}
	        //Integer count = (Integer) session.getAttribute("count");
	        Integer count = (Integer) session.getAttribute("count");
			count += 2;
			session.setAttribute("count", count);
	        return "index2.jsp";	
	}
	
	@RequestMapping("/counter")
	public String counter (HttpSession session){
	        return "counter.jsp";	
	}
	

		
			
		
	
	
	
}
