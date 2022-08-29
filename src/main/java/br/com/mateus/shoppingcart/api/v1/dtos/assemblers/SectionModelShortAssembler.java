package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.SectionController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.SectionModelShort;
import br.com.mateus.shoppingcart.domain.model.Section;

@Component
public class SectionModelShortAssembler extends RepresentationModelAssemblerSupport<Section, SectionModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public SectionModelShortAssembler() {
		super(SectionController.class, SectionModelShort.class);
	}

	@Override
	public SectionModelShort toModel(Section carad) {
		SectionModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<SectionModelShort> toCollectionModel(Iterable<? extends Section> entities) {
		CollectionModel<SectionModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
