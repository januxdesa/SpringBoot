package com.codingdojo.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {

	/* Haga que una solicitud GET a "http://localhost:8080/coding" muestre un texto que diga "¡Hola Coding Dojo!".
Haga que una solicitud GET a "http://localhost:8080/coding/python" muestre un texto que diga "¡Python/Django fue increíble!".
Haga que una solicitud GET a "http://localhost:8080/coding/java" muestre un texto que diga "¡Java/Spring es mejor!".*/

	@RequestMapping("")
	public String coding() {
		return "¡Hola Coding Dojo!";
	}
	
	@RequestMapping("/python")
	public String python() {
		return "¡Python/Django fue increíble!";
	}
	
	@RequestMapping("/java")
	public String java() {
		return "¡Java/Spring es mejor!";
	}
	
	
	
	

}
