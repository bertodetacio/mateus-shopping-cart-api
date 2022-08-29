package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.CreditCardControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.CreditCardModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CreditCardModelShort;
import br.com.mateus.shoppingcart.domain.model.CreditCard;
import br.com.mateus.shoppingcart.domain.services.CreditCardService;


@RestController
@RequestMapping(path = "api/v1/creditCards", produces = MediaType.APPLICATION_JSON_VALUE)
public class CreditCardController implements CreditCardControllerOpenApi {
		
	@Autowired
	private CreditCardService creditCardService;
	
	@Autowired
	private CreditCardModelShortAssembler creditCardModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<CreditCardModelShort> findAllCreditCards() {
		List <CreditCard> creditCardsList = creditCardService.findAllCreditCards();
		return creditCardModelShortAssembler.toCollectionModel(creditCardsList);
	}
	
	@Override
	@GetMapping(path = "/{creditCardId}")
	public CreditCardModelShort findCreditCardById(@PathVariable (name = "creditCardId", required = true) Long creditCardId) {
		CreditCard creditCard =  creditCardService.findCreditCardByIdOrFail(creditCardId);
		return creditCardModelShortAssembler.toModel(creditCard);
	}

	
	

}
