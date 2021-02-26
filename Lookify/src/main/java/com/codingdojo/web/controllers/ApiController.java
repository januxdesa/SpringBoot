package com.codingdojo.web.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codingdojo.web.models.PlayList;
import com.codingdojo.web.services.PlayListService;


@RestController
public class ApiController {
    private final PlayListService playListService;
    
    public ApiController(PlayListService playListService){
        this.playListService = playListService;
    }
    
    @RequestMapping("/api/languages")
    public List<PlayList> index() {
        return playListService.allLanguage();
    }
    
   
    
    
}
