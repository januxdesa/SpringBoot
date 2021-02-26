package com.codingdojo.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.web.models.TagQuestion;
public interface TagsQuestionsRepository extends CrudRepository<TagQuestion,Long> {

	
	  List<TagQuestion> findAll();

	  void deleteAllInBatch();

	//void save(Question question);

	
	  
	  
}
