package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.PersonNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Person;
import br.com.mateus.shoppingcart.domain.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PersonService {
		
	@Autowired
	private PersonRepository personRepository;
	
	public  List<Person> findAllsPersons(){
		return personRepository.findAll();
	}
	
	public Person findPersonByIdOrFail(Long personId) {
		return personRepository.findById(personId).orElseThrow(() -> new PersonNotFoundException(personId));
	}
	

}
