package com.codingdojo.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.web.models.PlayList;
import com.codingdojo.web.services.PlayListService;

@Controller
public class WebController {
    private final PlayListService playListService;
    
    public WebController(PlayListService playListService) {
        this.playListService = playListService;
    }
    
   
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String redirect() {
    
        return "index.jsp";
    }
    
    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public String dashboard(@ModelAttribute("playlist") PlayList playList, BindingResult result, Model model) {
        
    	List<PlayList> playLists = playListService.allLanguage();
        model.addAttribute("playlists", playLists);
       
        return "dashboard.jsp";
    }
    
    @RequestMapping(value="/songs/new", method = RequestMethod.GET)
    public String newGet(@ModelAttribute("playlist") PlayList playList, BindingResult result, Model model) {
        
    	List<PlayList> playLists = playListService.allLanguage();
        model.addAttribute("playlists", playLists);
       
        return "new.jsp";
    }
   
    
    @RequestMapping(value="/songs/new", method = RequestMethod.POST)
    public String newPost(@ModelAttribute("playlist") PlayList playList, BindingResult result, Model model) {
        
    	if (result.hasErrors())
    	return "new.jsp";
    	else return "new.jsp";
    
    }
   
    
    
  
    
    /*
    @RequestMapping(value="/languages", method = RequestMethod.GET)
    public String index(Model model, @ModelAttribute("language") PlayList playList, BindingResult result) {
        
    	List<PlayList> playLists = playListService.allLanguage();
        model.addAttribute("lang", playLists);
       
        return "/views/index.jsp";
    }
   
     
     @RequestMapping(value="/languages", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") PlayList playList, BindingResult result, Model model) {
    	 
    	 
    	if (result.hasErrors()) {
            return "/views/new.jsp";
        } else {
            playListService.createLanguage(playList);
            return "redirect:/languages";
        }
    }
   

    @RequestMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
   
        PlayList playLists = playListService.findLanguage(id);
        model.addAttribute("languages", playLists);
        return "/views/show.jsp";
    }
    
    
    
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        PlayList playList = playListService.findLanguage(id);
        model.addAttribute("language", playList);
        return "/views/edit.jsp";
    }
    
    
    
    @RequestMapping("/languages/new")
    public String newLanguage(@ModelAttribute("language") PlayList playList) {
        return "/views/new.jsp";
    }
    
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") PlayList playList, BindingResult result) {
        if (result.hasErrors()) {
            return "/views/edit.jsp";
        } else {
            playListService.updateLanguage(playList);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        playListService.deleteLanguage(id);
        return "redirect:/languages";
    }
    
    
     @RequestMapping("/languages/{id}/delete")
    public String delete(@PathVariable("id") Long id, Model model) {
    	 playListService.deleteLanguage(id);
         return "redirect:/languages";
    }
    
    */
    
    
}