package com.codingdojo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.codingdojo.web.models.Answer;
import com.codingdojo.web.models.Question;
import com.codingdojo.web.models.Tag;
import com.codingdojo.web.models.TagQuestion;
import com.codingdojo.web.repositories.AnswersRepository;
import com.codingdojo.web.repositories.QuestionsRepository;
import com.codingdojo.web.repositories.TagsQuestionsRepository;
import com.codingdojo.web.repositories.TagsRepository;


@SpringBootApplication
public class DojoOverFlowApplication implements CommandLineRunner {

	@Autowired 
	private AnswersRepository answersRepository; 
	@Autowired
	private QuestionsRepository questionsRepository; 
	@Autowired
	private TagsRepository tagsRepository; 
	@Autowired
	private TagsQuestionsRepository tagsquestionsRepository; 
	
	
	public static void main(String[] args) {
		SpringApplication.run(DojoOverFlowApplication.class, args);
	}

	 @Override
	    public void run(String... args) throws Exception {
		/* 
		questionsRepository.deleteAllInBatch();
	    answersRepository.deleteAllInBatch();
	    tagsRepository.deleteAllInBatch();
	    tagsquestionsRepository.deleteAllInBatch();
	    
	    
	    Question question = new Question("Pregunta 1");

        // Create two tags
        Tag tag1 = new Tag("Spring");
        Tag tag2 = new Tag("Boot");
        
        
        // Add tag references in the post
        question.getTag().add(tag1);
        question.getTag().add(tag2);
        
        tag1.getQuestion().add(question);
        tag2.getQuestion().add(question);
        
           
        questionsRepository.save(question);
        
        */
       
	 }
}
