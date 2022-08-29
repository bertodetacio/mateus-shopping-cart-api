package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.CityController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CityModelShort;
import br.com.mateus.shoppingcart.domain.model.City;

@Component
public class CityModelShortAssembler extends RepresentationModelAssemblerSupport<City, CityModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public CityModelShortAssembler() {
		super(CityController.class, CityModelShort.class);
	}

	@Override
	public CityModelShort toModel(City carad) {
		CityModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<CityModelShort> toCollectionModel(Iterable<? extends City> entities) {
		CollectionModel<CityModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
