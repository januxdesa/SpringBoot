package com.codingdojo.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.codingdojo.web.models.Question;

@Repository
public interface QuestionsRepository extends CrudRepository<Question, Long>{

	
	List<Question> findAll();

	void deleteAllInBatch();
	  
	    //Este método encuentra un libro por su descripción
	   // List<Question> findByDescriptionContaining(String search);
	    //Este método cuenta cuántos libros contiene cierta cadena en el título
	  //  Long countByTitleContaining(String search);
	    //Este método borra un libro que empieza con un título específico
	 //   Long deleteByTitleStartingWith(String search);
	
}
