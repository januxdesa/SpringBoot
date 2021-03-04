package com.codingdojo.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingdojo.web.controllers.BooksController;
import com.codingdojo.web.models.Author;
import com.codingdojo.web.models.Book;

@SpringBootTest
class BookApplicationTests {

	@Autowired
    // use the name of the controller you create in your project
    private BooksController controller;
	
	private static Validator validator;
    
	@BeforeAll
	static void setUp() {
	    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    validator = factory.getValidator();
	}
	
	@Test
	void contextLoads() {
	}
	
	@Test
    void testController() {
        assertThat(controller).isNotNull();
    }
	
	@Test
	void assumeFirstNameisEmpty() {
	   // Book book = new Book();
	    Author author = new Author(); 
	    author.setFirstName("");
	    author.setLastName("Test");
	    author.setDescription("Description");
	    Set<ConstraintViolation<Author>> violations = validator.validate(author);
	   // assertFalse(violations.isEmpty());
	    assertTrue(violations.isEmpty());
	}
	@Test
	void assumeFirstNameIsSizeMinor() {
	   // Book book = new Book();
	    Author author = new Author(); 
	    author.setFirstName("P");
	    author.setLastName("Test");
	    author.setDescription("Description");
	    Set<ConstraintViolation<Author>> violations = validator.validate(author);
	    assertTrue(violations.isEmpty());
	}
	
	@Test
	void assumeLastNameIsNull() {
	   // Book book = new Book();
	    Author author = new Author(); 
	    author.setFirstName("Test");
	    author.setDescription("Description");
	    Set<ConstraintViolation<Author>> violations = validator.validate(author);
	    assertTrue(violations.isEmpty());
	}
	
	
	@Test
	void assumeDescriptionIsSizeMinor() {
	   // Book book = new Book();
	    Author author = new Author(); 
	    author.setFirstName("Pedro");
	    author.setLastName("Test");
	    author.setDescription("1234");
	    Set<ConstraintViolation<Author>> violations = validator.validate(author);
	    assertTrue(violations.isEmpty());
	}
	@Test
	void assumeDescriptionLastNameIsNull() {
	   // Book book = new Book();
	    Author author = new Author(); 
	    author.setFirstName("Pedro");
	    author.setLastName("Test");
	    Set<ConstraintViolation<Author>> violations = validator.validate(author);
	    assertFalse(violations.isEmpty());
	}

}
