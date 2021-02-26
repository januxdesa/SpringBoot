package com.codingdojo.web.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import com.codingdojo.web.models.Book;
import com.codingdojo.web.repositories.BookRepository;
@Service
public class BookService {
    //Agregando el book al repositorio como una dependencia
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //Devolviendo todos los libros.
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    //Creando un libro.
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    //Obteniendo la información de un libro
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		// TODO Auto-generated method stub
		Book book = new Book();
		Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            optionalBook.get().setTitle(title);
            optionalBook.get().setDescription(desc);
            optionalBook.get().setLanguage(lang);
            optionalBook.get().setNumberOfPages(numOfPages);
            
            
        } else {
            return null;
        }
        
        
        book = optionalBook.get();
        
        
		return bookRepository.save(book);
	}
	public void updateBook(@Valid Book book) {
		// TODO Auto-generated method stub
		
		
		bookRepository.save(book);
	}
	
    
   
}