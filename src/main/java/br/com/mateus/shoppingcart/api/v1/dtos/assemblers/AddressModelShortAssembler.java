package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.AddressController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.AddressModelShort;
import br.com.mateus.shoppingcart.domain.model.Address;

@Component
public class AddressModelShortAssembler extends RepresentationModelAssemblerSupport<Address, AddressModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public AddressModelShortAssembler() {
		super(AddressController.class, AddressModelShort.class);
	}

	@Override
	public AddressModelShort toModel(Address carad) {
		AddressModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<AddressModelShort> toCollectionModel(Iterable<? extends Address> entities) {
		CollectionModel<AddressModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
