package com.codingdojo.web.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.codingdojo.web.models.License;
import com.codingdojo.web.models.Person;


public interface LicenseRepository extends CrudRepository<License, Long> {

	List<License> findAll();
	 
	Optional<License> findById(Long id);
	
	long count();
	
	List<License> findByPerson(Person person);
	
	
}
