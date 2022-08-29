package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.CustomerController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CustomerModelShort;
import br.com.mateus.shoppingcart.domain.model.Customer;

@Component
public class CustomerModelShortAssembler extends RepresentationModelAssemblerSupport<Customer, CustomerModelShort> {
	
	@Autowired
	private ModelMapper modelMapper;

	public CustomerModelShortAssembler() {
		super(CustomerController.class, CustomerModelShort.class);
	}

	@Override
	public CustomerModelShort toModel(Customer customer) {
		CustomerModelShort customerModelShort = createModelWithId(customer.getId(), customer);
		modelMapper.map(customer, customerModelShort);
		return customerModelShort;
	}
	
	public CollectionModel<CustomerModelShort> toCollectionModel(Iterable<? extends Customer> entities) {
		CollectionModel<CustomerModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
