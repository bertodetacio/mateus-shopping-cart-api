package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.DigitalAccountController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.DigitalAccountModelShort;
import br.com.mateus.shoppingcart.domain.model.DigitalAccount;

@Component
public class DigitalAccountModelShortAssembler extends RepresentationModelAssemblerSupport<DigitalAccount, DigitalAccountModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public DigitalAccountModelShortAssembler() {
		super(DigitalAccountController.class, DigitalAccountModelShort.class);
	}

	@Override
	public DigitalAccountModelShort toModel(DigitalAccount carad) {
		DigitalAccountModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<DigitalAccountModelShort> toCollectionModel(Iterable<? extends DigitalAccount> entities) {
		CollectionModel<DigitalAccountModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
