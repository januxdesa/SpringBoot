package com.codingdojo.web.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.web.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {

	Optional<Ninja> findDojoById(Long id);
	
	 List<Ninja> findAll();

}
