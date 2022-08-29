package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.FiscalDocumentController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.FiscalDocumentModelShort;
import br.com.mateus.shoppingcart.domain.model.FiscalDocument;

@Component
public class FiscalDocumentModelShortAssembler extends RepresentationModelAssemblerSupport<FiscalDocument, FiscalDocumentModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public FiscalDocumentModelShortAssembler() {
		super(FiscalDocumentController.class, FiscalDocumentModelShort.class);
	}

	@Override
	public FiscalDocumentModelShort toModel(FiscalDocument carad) {
		FiscalDocumentModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<FiscalDocumentModelShort> toCollectionModel(Iterable<? extends FiscalDocument> entities) {
		CollectionModel<FiscalDocumentModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
