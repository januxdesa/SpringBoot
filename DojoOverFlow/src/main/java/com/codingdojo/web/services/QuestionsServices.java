package com.codingdojo.web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.web.models.Question;
import com.codingdojo.web.repositories.QuestionsRepository;

@Service
public class QuestionsServices {
	
	private final QuestionsRepository questionsRepository;
	
	public QuestionsServices(QuestionsRepository questionsRepository) {
		this.questionsRepository = questionsRepository;
	}
	
	public List<Question> all() {
        return questionsRepository.findAll();
    }
	
	
	
	
}
