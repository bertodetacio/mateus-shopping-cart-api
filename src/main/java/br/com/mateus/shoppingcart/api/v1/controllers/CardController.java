package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.CardControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.CardModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CardModelShort;
import br.com.mateus.shoppingcart.domain.model.Card;
import br.com.mateus.shoppingcart.domain.services.CardService;


@RestController
@RequestMapping(path = "api/v1/cards", produces = MediaType.APPLICATION_JSON_VALUE)
public class CardController implements CardControllerOpenApi {
		
	@Autowired
	private CardService cardService;
	
	@Autowired
	private CardModelShortAssembler cardModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<CardModelShort> findAllCards() {
		List <Card> cardsList = cardService.findAllsCards();
		return cardModelShortAssembler.toCollectionModel(cardsList);
	}
	
	@Override
	@GetMapping(path = "/{cardId}")
	public CardModelShort findCardById(@PathVariable (name = "cardId", required = true) Long cardId) {
		Card card =  cardService.findCardByIdOrFail(cardId);
		return cardModelShortAssembler.toModel(card);
	}

	
	

}
