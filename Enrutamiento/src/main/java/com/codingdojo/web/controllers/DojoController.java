package com.codingdojo.web.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DojoController {

	/*
	 * Crear otro controlador llamado "DojoController". Para las rutas a
	 * continuación, utilice la anotación @PathVariable. Haga que una solicitud GET
	 * a "http://localhost:8080/dojo" muestre un texto que diga
	 * "¡El Dojo es increíble!". Haga que una solicitud GET a
	 * "http://localhost:8080/burbank-dojo" muestre un texto que diga
	 * "El Dojo Burbank está localizado al sur de California". Haga que una
	 * solicitud GET a "http://localhost:8080/san-jose" muestre un texto que diga
	 * "El Dojo SJ es el cuartel general".
	 */
	@RequestMapping("/{ruta}")
	public String showDojo(@PathVariable("ruta") String ruta) {
		String out = "";
		if (ruta.equals("dojo")) {
			out = "¡El Dojo es increíble!";
		} else if (ruta.equals("burbank-dojo")) {
			out = "El Dojo Burbank está localizado al sur de California";
		} else if (ruta.equals("san-jose")) {
			out = "El Dojo SJ es el cuartel general";
		}
		

		return out;

	}

	

}
