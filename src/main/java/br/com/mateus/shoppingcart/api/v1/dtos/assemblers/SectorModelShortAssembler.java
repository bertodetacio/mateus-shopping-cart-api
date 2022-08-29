package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.SectorController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.SectorModelShort;
import br.com.mateus.shoppingcart.domain.model.Sector;

@Component
public class SectorModelShortAssembler extends RepresentationModelAssemblerSupport<Sector, SectorModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public SectorModelShortAssembler() {
		super(SectorController.class, SectorModelShort.class);
	}

	@Override
	public SectorModelShort toModel(Sector carad) {
		SectorModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<SectorModelShort> toCollectionModel(Iterable<? extends Sector> entities) {
		CollectionModel<SectorModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
