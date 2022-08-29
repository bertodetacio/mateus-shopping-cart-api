package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.OccupationController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.OccupationModelShort;
import br.com.mateus.shoppingcart.domain.model.Occupation;

@Component
public class OccupationModelShortAssembler extends RepresentationModelAssemblerSupport<Occupation, OccupationModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public OccupationModelShortAssembler() {
		super(OccupationController.class, OccupationModelShort.class);
	}

	@Override
	public OccupationModelShort toModel(Occupation carad) {
		OccupationModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<OccupationModelShort> toCollectionModel(Iterable<? extends Occupation> entities) {
		CollectionModel<OccupationModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
