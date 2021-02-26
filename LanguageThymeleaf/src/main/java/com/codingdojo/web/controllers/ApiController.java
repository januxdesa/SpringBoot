package com.codingdojo.web.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.web.models.Language;
import com.codingdojo.web.services.LanguageService;


@RestController
public class ApiController {
    private final LanguageService languageService;
    
    public ApiController(LanguageService languageService){
        this.languageService = languageService;
    }
    
    @RequestMapping("/api/languages")
    public List<Language> index() {
        return languageService.allLanguage();
    }
    
    @RequestMapping(value="/api/languages", method=RequestMethod.POST)
    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentversion") String currentversion) {
        Language language = new Language(name, creator, currentversion);
        return languageService.createLanguage(language);
    }
    
    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id) {
        Language language = languageService.findLanguage(id);
        return language;
    }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
    }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
    public Language update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentversion") String currentversion) {
        Language language = languageService.updateLanguage(id, name, creator, currentversion);
        return language;
    }
    
    
}
