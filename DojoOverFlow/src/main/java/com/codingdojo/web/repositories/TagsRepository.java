package com.codingdojo.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.web.models.Tag;

@Repository
public interface TagsRepository extends CrudRepository<Tag, Long> {

	 List<Tag> findAll();

	void deleteAllInBatch();

	
	  
	    //Este método encuentra un libro por su descripción
	// save(Tag tag);
	 
}
