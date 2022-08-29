package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.PersonControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.PersonModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.PersonModelShort;
import br.com.mateus.shoppingcart.domain.model.Person;
import br.com.mateus.shoppingcart.domain.services.PersonService;


@RestController
@RequestMapping(path = "api/v1/persons", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController implements PersonControllerOpenApi {
		
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonModelShortAssembler personModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<PersonModelShort> findAllPersons() {
		List <Person> personsList = personService.findAllsPersons();
		return personModelShortAssembler.toCollectionModel(personsList);
	}
	
	@Override
	@GetMapping(path = "/{personId}")
	public PersonModelShort findPersonById(@PathVariable (name = "personId", required = true) Long personId) {
		Person person =  personService.findPersonByIdOrFail(personId);
		return personModelShortAssembler.toModel(person);
	}

	
	

}
