package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.BrandingController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.BrandingModelShort;
import br.com.mateus.shoppingcart.domain.model.Branding;

@Component
public class BrandingModelShortAssembler extends RepresentationModelAssemblerSupport<Branding, BrandingModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public BrandingModelShortAssembler() {
		super(BrandingController.class, BrandingModelShort.class);
	}

	@Override
	public BrandingModelShort toModel(Branding carad) {
		BrandingModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<BrandingModelShort> toCollectionModel(Iterable<? extends Branding> entities) {
		CollectionModel<BrandingModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
