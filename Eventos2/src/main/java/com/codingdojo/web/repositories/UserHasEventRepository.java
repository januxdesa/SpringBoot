package com.codingdojo.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.web.models.UserHasEvent;

public interface UserHasEventRepository extends CrudRepository<UserHasEvent,Long> {

	// List<UserHasEvent> findByEvent(Long id);

	//List<UserHasEvent> findByEventId(Long id);

	//void save(UserHasEvent uhe);
	
    

}
