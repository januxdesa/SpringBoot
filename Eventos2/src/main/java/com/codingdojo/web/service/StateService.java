package com.codingdojo.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.web.models.State;
import com.codingdojo.web.repositories.StateRepository;



@Service
public class StateService {
	
	private final StateRepository stateRepository;
	
	public StateService( StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}

	public List<State> findAll() {
		
		return stateRepository.findAll();
	}

		
}
