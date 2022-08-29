package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.IndividualCustomerController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.IndividualCustomerModelShort;
import br.com.mateus.shoppingcart.domain.model.IndividualCustomer;

@Component
public class IndividualCustomerModelShortAssembler extends RepresentationModelAssemblerSupport<IndividualCustomer, IndividualCustomerModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public IndividualCustomerModelShortAssembler() {
		super(IndividualCustomerController.class, IndividualCustomerModelShort.class);
	}

	@Override
	public IndividualCustomerModelShort toModel(IndividualCustomer individualCustomer) {
		IndividualCustomerModelShort individualCustomerModelShort = createModelWithId(individualCustomer.getId(), individualCustomer);
		modelMapper.map(individualCustomer, individualCustomerModelShort);
		return individualCustomerModelShort;
	}
	
	public CollectionModel<IndividualCustomerModelShort> toCollectionModel(Iterable<? extends IndividualCustomer> entities) {
		CollectionModel<IndividualCustomerModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
