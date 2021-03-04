package com.codingdojo.web.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.codingdojo.web.models.Dojo;
import com.codingdojo.web.models.Ninja;
import com.codingdojo.web.repositories.DojoRepository;

@Service
public class DojoService {
	
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}

	public void save(@Valid Dojo dojo) {
		// TODO Auto-generated method stub
		dojoRepository.save(dojo);
	}

	public List<Dojo> findAll() {
		// TODO Auto-generated method stub
		return (List<Dojo>) dojoRepository.findAll();
	}

	
	public List<Dojo> findDojoById(Long id) {
		
		List<Dojo> dojos = dojoRepository.findAll();
		List<Dojo> temp = dojoRepository.findAll();;
		temp.clear();
		for (var i=0; i < dojos.size(); i++) {
			
			if (dojos.get(i).getId()==id) {
				temp.add(dojos.get(i));
			}
		}
		
		return temp;
		
	}
	
	
}
