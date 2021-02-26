package com.codingdojo.web.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.codingdojo.web.models.License;
import com.codingdojo.web.models.Person;
import com.codingdojo.web.services.LicenseServices;
import com.codingdojo.web.services.PersonServices;


@Controller 
public class LicenseControllers {
	
	//@Autowired
	private LicenseServices licenseServices;
	//@Autowired
	private PersonServices personServices;
	
	
	public LicenseControllers(LicenseServices licenseServices, PersonServices personServices) {
		this.licenseServices = licenseServices;	
		this.personServices = personServices;
	}
	
	
	
	@RequestMapping(value = "/licenses/new" , method=RequestMethod.GET)
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


}
