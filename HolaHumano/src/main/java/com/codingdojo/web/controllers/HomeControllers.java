package com.codingdojo.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeControllers {

	@RequestMapping("")
	public String Respuesta(@RequestParam(value = "name", required = false) String searchName,
			@RequestParam(value = "last", required = false) String searchLast) {

		String msg = "";
		
		if (searchName==null) { searchName = ""; }

		if (searchLast==null) { searchLast = "";}
		
		if (searchName.equals("") && searchLast.equals("")) {
			msg  = "Hola Humano";
		}
		else if (!searchName.equals("") && !searchLast.equals("")) {
			msg = "Hola "  + searchName + " " + searchLast;
		}
		else {

			msg = "Hola "  + searchName + " " + searchLast;
		}
		

		return msg;

		// return "Hola Humano";
	}
}
