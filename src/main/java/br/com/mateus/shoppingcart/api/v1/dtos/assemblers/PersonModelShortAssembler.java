package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.PersonController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.PersonModelShort;
import br.com.mateus.shoppingcart.domain.model.Person;

@Component
public class PersonModelShortAssembler extends RepresentationModelAssemblerSupport<Person, PersonModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public PersonModelShortAssembler() {
		super(PersonController.class, PersonModelShort.class);
	}

	@Override
	public PersonModelShort toModel(Person carad) {
		PersonModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<PersonModelShort> toCollectionModel(Iterable<? extends Person> entities) {
		CollectionModel<PersonModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
