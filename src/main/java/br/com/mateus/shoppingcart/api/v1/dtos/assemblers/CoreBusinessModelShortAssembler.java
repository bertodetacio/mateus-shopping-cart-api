package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.CoreBusinessController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CoreBusinessModelShort;
import br.com.mateus.shoppingcart.domain.model.CoreBusiness;

@Component
public class CoreBusinessModelShortAssembler extends RepresentationModelAssemblerSupport<CoreBusiness, CoreBusinessModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public CoreBusinessModelShortAssembler() {
		super(CoreBusinessController.class, CoreBusinessModelShort.class);
	}

	@Override
	public CoreBusinessModelShort toModel(CoreBusiness carad) {
		CoreBusinessModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<CoreBusinessModelShort> toCollectionModel(Iterable<? extends CoreBusiness> entities) {
		CollectionModel<CoreBusinessModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
