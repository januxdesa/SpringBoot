package com.codingdojo.web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.web.models.Answer;
import com.codingdojo.web.repositories.AnswersRepository;


@Service
public class AnswersServices {

	private final AnswersRepository answersRepository;
	
	public AnswersServices(AnswersRepository answersRepository) {
		this.answersRepository = answersRepository;
	}
	public List<Answer> all() {
		// TODO Auto-generated method stub
		 return answersRepository.findAll();
		
	}

	
}
