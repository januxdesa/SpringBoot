package com.codingdojo.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.web.models.State;

@Repository
public interface StateRepository extends CrudRepository<State,Long>{

	List<State> findAll();
	
}
