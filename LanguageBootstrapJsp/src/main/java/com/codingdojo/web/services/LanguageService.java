package com.codingdojo.web.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import com.codingdojo.web.models.Language;
import com.codingdojo.web.repositories.LanguageRepository;
@Service
public class LanguageService {
    //Agregando el book al repositorio como una dependencia
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    //Devolviendo todos los libros.
    public List<Language> allLanguage() {
        return languageRepository.findAll();
        
    }
    //Creando un lenguaje
    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }
    //Obteniendo la información de un libro
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
	public void deleteLanguage(Long id) {
		// TODO Auto-generated method stub
		languageRepository.deleteById(id);
	}
	public Language updateLanguage(Long id, String name, String creator, String currentVersion) {
		// TODO Auto-generated method stub
		Language language = new Language();
		Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            optionalLanguage.get().setName(name);
            optionalLanguage.get().setCreator(creator);
            optionalLanguage.get().setCurrentVersion(currentVersion);
            
            
            
        } else {
            return null;
        }
        
        
        language = optionalLanguage.get();
        
        
		return languageRepository.save(language);
	}
	public void updateLanguage(@Valid Language language) {
		// TODO Auto-generated method stub
		
		
		languageRepository.save(language);
	}
	
    
   
}