package com.codingdojo.web.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/gold")
public class HomeController {

	List<String> lista = new ArrayList<String>();
	
	@RequestMapping("")
	public String index(Model model) {
		
		/*
		model.addAttribute("gold", gold);
		model.addAttribute("log", log);
		model.addAttribute("name",result);
		*/
		
		return "index.jsp";
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public String result(@RequestParam(value="result") String result, Model model, HttpSession session ) {
		Random r= new Random();
		
		int gold;
		int generado;
		String msg;
		String goldS;
		
		
		
		if (session.getAttribute("log") == null   || session.getAttribute("log") == "" )     {lista.add("Bienvenidos"); }
		if (session.getAttribute("gold") ==  null ||  session.getAttribute("gold") == "" ) { System.out.println("OK");session.setAttribute("gold", "0"); } 
		
		
		
		//log = (List) session.getAttribute("log");
		
		switch (result) {
		
		case "farm": 
			
			goldS = session.getAttribute("gold").toString();
			gold = Integer.parseInt(goldS);	
			generado = r.nextInt(20) + 10;	
			gold = gold + generado;
			msg = "<li class=\"list-group-item text-success \"> Tu has entrado a la " + result +  " y generaste " + generado + " (" +  new Date()  + ") </li>";
			
			lista.add(msg);
			goldS  = gold + ""; 
			session.setAttribute("gold", goldS);
			break;
			
		case "cave":
			goldS = session.getAttribute("gold").toString();
			gold = Integer.parseInt(goldS);	
			generado = r.nextInt(10) + 5;	
			gold = gold + generado;
			msg = "<li class=\"list-group-item text-success \"> Tu has entrado a la " + result +  " y generaste " + generado + " (" +  new Date()  + ") </li>";
			
			lista.add(msg);
			goldS  = gold + ""; 
			session.setAttribute("gold", goldS);
			break;
			
		case "house":
			goldS = session.getAttribute("gold").toString();
			gold = Integer.parseInt(goldS);	
			generado = r.nextInt(5) + 2;	
			gold = gold + generado;
			msg = "<li class=\"list-group-item text-success \"> Tu has entrado a la " + result +  " y generaste " + generado + " (" +  new Date()  + ") </li>";
			
			lista.add(msg);
			goldS  = gold + ""; 
			session.setAttribute("gold", goldS);
			break;
			
		case "casino":
			goldS = session.getAttribute("gold").toString();
			gold = Integer.parseInt(goldS);	
			generado = r.nextInt(50);	
			int aleatorio = r.nextInt(2);
			
			if (aleatorio < 1) { generado = generado * -1; } 
			
			gold = gold + generado;
			if (generado>0) {
				msg = "<li class=\"list-group-item text-success \"> Tu has entrado al " + result +  " y generaste " + generado + " (" +  new Date()  + ") </li>";
			} else {
				msg = "<li class=\"list-group-item text-danger \"> Tu has entrado al " + result +  " y perdiste " + generado + " (" +  new Date()  + ") </li>";
					
			}
			lista.add(msg);
			goldS  = gold + ""; 
			session.setAttribute("gold", goldS);
			break;
			
		}
		
		session.setAttribute("log", lista);
		
		return "index.jsp";
	}
	
	
	
	
		
}
