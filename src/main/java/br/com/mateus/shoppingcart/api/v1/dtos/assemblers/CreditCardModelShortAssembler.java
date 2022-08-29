package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.CreditCardController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CreditCardModelShort;
import br.com.mateus.shoppingcart.domain.model.CreditCard;

@Component
public class CreditCardModelShortAssembler extends RepresentationModelAssemblerSupport<CreditCard, CreditCardModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public CreditCardModelShortAssembler() {
		super(CreditCardController.class, CreditCardModelShort.class);
	}

	@Override
	public CreditCardModelShort toModel(CreditCard carad) {
		CreditCardModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<CreditCardModelShort> toCollectionModel(Iterable<? extends CreditCard> entities) {
		CollectionModel<CreditCardModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
