package com.codingdojo.web.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.web.models.Dojo;


@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {

	Optional<Dojo> findById(Long id);

	List<Dojo> findAll();
	
}
