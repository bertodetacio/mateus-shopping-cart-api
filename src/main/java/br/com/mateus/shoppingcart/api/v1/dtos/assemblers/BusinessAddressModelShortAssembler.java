package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.BusinessAddressController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.BusinessAddressModelShort;
import br.com.mateus.shoppingcart.domain.model.BusinessAddress;

@Component
public class BusinessAddressModelShortAssembler extends RepresentationModelAssemblerSupport<BusinessAddress, BusinessAddressModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public BusinessAddressModelShortAssembler() {
		super(BusinessAddressController.class, BusinessAddressModelShort.class);
	}

	@Override
	public BusinessAddressModelShort toModel(BusinessAddress businessAddress) {
		BusinessAddressModelShort businessAddressModelShort = createModelWithId(businessAddress.getId(), businessAddress);
		modelMapper.map(businessAddress, businessAddressModelShort);
		return businessAddressModelShort;
	}
	
	public CollectionModel<BusinessAddressModelShort> toCollectionModel(Iterable<? extends BusinessAddress> entities) {
		CollectionModel<BusinessAddressModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
