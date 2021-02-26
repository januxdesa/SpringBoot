package com.codingdojo.web.services;



import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.codingdojo.web.models.Person;
import com.codingdojo.web.repositories.PersonRepository;

@Service
public class PersonServices {

	private final PersonRepository personRepository;
	
	public PersonServices(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public void createperson(Person person) {
		// TODO Auto-generated method stub
		personRepository.save(person);
	}
	
	public List<Person> findAllPersons() {
		return personRepository.findAll();
	}
	
	
	public Person findPerson(Long id) {
        Optional<Person> optionalPerson= personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }

}
