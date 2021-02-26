package com.codingdojo.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.web.models.Language;
import com.codingdojo.web.services.LanguageService;

@Controller
public class WebController {
    private final LanguageService languageService;
    
    public WebController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
  
    /* @RequestMapping(value="/languages", method = RequestMethod.GET)
    public String index(Model model, @ModelAttribute("language") Language language, BindingResult result) {
        
    	List<Language> languages = languageService.allLanguage();
        model.addAttribute("lang", languages);
        model.addAttribute("name", "World!!!");
       
        return "index.html";
    }*/ 
   /*
      @RequestMapping(value="/languages", method = RequestMethod.GET)
    public String index(Model model) {
        
    	List<Language> languages = languageService.allLanguage();
        model.addAttribute("lang", languages);
        model.addAttribute("name", "World!!!");
       
        return "index.html";
    }
    */
    @GetMapping("/languages")
    public String index(Model model,  @ModelAttribute("language") Language language, BindingResult result) {
        
    	List<Language> languages = languageService.allLanguage();
        model.addAttribute("lang", languages);
        model.addAttribute("name", "World!!!");
       
        return "index.html";
    }
    
   
     
     @RequestMapping(value="/languages", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
    	 
    	 
    	/* if (result.hasErrors()) {
            return "/views/new.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        } */
    	
    	return "redirect:/languages";
    }
   
    
   
    
    
    
    @RequestMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
   
        Language languages = languageService.findLanguage(id);
        model.addAttribute("languages", languages);
        return "/views/show.jsp";
    }
    
    
    
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/views/edit.jsp";
    }
    
    
    
    @RequestMapping("/languages/new")
    public String newLanguage(@ModelAttribute("language") Language language) {
        return "/views/new.jsp";
    }
    
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/views/edit.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
    
    /* 
     @RequestMapping("/languages/{id}/delete")
    public String delete(@PathVariable("id") Long id, Model model) {
    	 languageService.deleteLanguage(id);
         return "redirect:/languages";
    }
    
     */
    
    
}