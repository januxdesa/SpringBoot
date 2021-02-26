package com.codingdojo.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.web.models.PlayList;



@Repository
public interface PlayListRepository extends CrudRepository<PlayList, Long>{
    //Este método recupera todos los libros de la base de datos
    List<PlayList> findAll();
    //Este método encuentra un libro por su descripción
    //List<Language> findByDescriptionContaining(String search);
    //Este método cuenta cuántos libros contiene cierta cadena en el título
    //Long countByTitleContaining(String search);
    //Este método borra un libro que empieza con un título específico
    //Long deleteByTitleStartingWith(String search);
    //
	//Book saveAll(Optional<Book> optionalBook);
   
	//Book save(Book b);
   // LanguageRepository.
	
}