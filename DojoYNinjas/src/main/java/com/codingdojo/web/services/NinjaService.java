package com.codingdojo.web.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.codingdojo.web.models.Ninja;
import com.codingdojo.web.repositories.NinjaRepository;
@Service
public class NinjaService {

	private final NinjaRepository ninjaRepository ;
	
	public NinjaService(NinjaRepository ninjaRepository ) {
		this.ninjaRepository = ninjaRepository;
	}

	public void save(@Valid Ninja ninja) {
		// TODO Auto-generated method stub
		ninjaRepository.save(ninja);
	}


	
	public Ninja findNinjaById(Long id) {
		// TODO Auto-generated method stub
		
		
		Optional<Ninja> lista = ninjaRepository.findDojoById(id);
		
		if(lista.isPresent()){
		   return lista.get();
		}
		else {
			return null;
		}
		
		
	}

	public List<Ninja> findDojoById(Long id) {
		// TODO Auto-generated method stub
		//Optional<Ninja> lista = dojoRepository.findById(id);
		
		List<Ninja> ninjas = ninjaRepository.findAll();
		List<Ninja> temp = ninjaRepository.findAll();;
		temp.clear();
		for (var i=0; i < ninjas.size(); i++) {
			
			if (ninjas.get(i).getDojo().getId()==id) {
				temp.add(ninjas.get(i));
			}
		}
		
		return temp;
	}

	
	
	
	
}
