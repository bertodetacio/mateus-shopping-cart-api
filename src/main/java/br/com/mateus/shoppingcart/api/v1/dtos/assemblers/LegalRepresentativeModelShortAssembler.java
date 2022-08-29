package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.LegalRepresentativeController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.LegalRepresentativeModelShort;
import br.com.mateus.shoppingcart.domain.model.LegalRepresentative;

@Component
public class LegalRepresentativeModelShortAssembler extends RepresentationModelAssemblerSupport<LegalRepresentative, LegalRepresentativeModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public LegalRepresentativeModelShortAssembler() {
		super(LegalRepresentativeController.class, LegalRepresentativeModelShort.class);
	}

	@Override
	public LegalRepresentativeModelShort toModel(LegalRepresentative legalRepresentative) {
		LegalRepresentativeModelShort legalRepresentativeModelShort = createModelWithId(legalRepresentative.getId(), legalRepresentative);
		modelMapper.map(legalRepresentative, legalRepresentativeModelShort);
		return legalRepresentativeModelShort;
	}
	
	public CollectionModel<LegalRepresentativeModelShort> toCollectionModel(Iterable<? extends LegalRepresentative> entities) {
		CollectionModel<LegalRepresentativeModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
