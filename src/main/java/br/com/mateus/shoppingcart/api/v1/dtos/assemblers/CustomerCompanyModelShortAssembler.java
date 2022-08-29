package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.CustomerCompanyController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CustomerCompanyModelShort;
import br.com.mateus.shoppingcart.domain.model.CustomerCompany;

@Component
public class CustomerCompanyModelShortAssembler extends RepresentationModelAssemblerSupport<CustomerCompany, CustomerCompanyModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public CustomerCompanyModelShortAssembler() {
		super(CustomerCompanyController.class, CustomerCompanyModelShort.class);
	}

	@Override
	public CustomerCompanyModelShort toModel(CustomerCompany carad) {
		CustomerCompanyModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<CustomerCompanyModelShort> toCollectionModel(Iterable<? extends CustomerCompany> entities) {
		CollectionModel<CustomerCompanyModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
