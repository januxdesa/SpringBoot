package com.codingdojo.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.web.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
	
	List<Event> findAll();
	

}
