package com.codingdojo.web.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import com.codingdojo.web.models.PlayList;
import com.codingdojo.web.repositories.PlayListRepository;
@Service
public class PlayListService {
    //Agregando el book al repositorio como una dependencia
    private final PlayListRepository playListRepository;
    
    public PlayListService(PlayListRepository playListRepository) {
        this.playListRepository = playListRepository;
    }
    //Devolviendo todos los libros.
    public List<PlayList> allLanguage() {
        return playListRepository.findAll();
        
    }
    //Creando un lenguaje
    public PlayList createPlayList(PlayList l) {
        return playListRepository.save(l);
    }
    
    //Obteniendo la información de un libro
    public PlayList findLanguage(Long id) {
        Optional<PlayList> optionalLanguage = playListRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
	public void deleteLanguage(Long id) {
		// TODO Auto-generated method stub
		playListRepository.deleteById(id);
	}
	public PlayList updateLanguage(Long id, String name, String creator, String currentVersion) {
		// TODO Auto-generated method stub
		PlayList playList = new PlayList();
		Optional<PlayList> optionalLanguage = playListRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            //optionalLanguage.get().setName(name);
           //optionalLanguage.get().setCreator(creator);
           // optionalLanguage.get().setCurrentVersion(currentVersion);
        } else {
            return null;
        }
        
        
        playList = optionalLanguage.get();
        
        
		return playListRepository.save(playList);
	}
	public void updateLanguage(@Valid PlayList playList) {
		// TODO Auto-generated method stub
		
		
		playListRepository.save(playList);
	}
	
    
   
}