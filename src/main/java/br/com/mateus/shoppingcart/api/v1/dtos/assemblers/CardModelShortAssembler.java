package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.CardController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CardModelShort;
import br.com.mateus.shoppingcart.domain.model.Card;

@Component
public class CardModelShortAssembler extends RepresentationModelAssemblerSupport<Card, CardModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public CardModelShortAssembler() {
		super(CardController.class, CardModelShort.class);
	}

	@Override
	public CardModelShort toModel(Card carad) {
		CardModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<CardModelShort> toCollectionModel(Iterable<? extends Card> entities) {
		CollectionModel<CardModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
