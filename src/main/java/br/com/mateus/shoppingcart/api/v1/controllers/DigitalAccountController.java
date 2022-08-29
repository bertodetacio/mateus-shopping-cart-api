package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.DigitalAccountControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.DigitalAccountModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.DigitalAccountModelShort;
import br.com.mateus.shoppingcart.domain.model.DigitalAccount;
import br.com.mateus.shoppingcart.domain.services.DigitalAccountService;


@RestController
@RequestMapping(path = "api/v1/digitalAccounts", produces = MediaType.APPLICATION_JSON_VALUE)
public class DigitalAccountController implements DigitalAccountControllerOpenApi {
		
	@Autowired
	private DigitalAccountService digitalAccountService;
	
	@Autowired
	private DigitalAccountModelShortAssembler digitalAccountModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<DigitalAccountModelShort> findAllDigitalAccounts() {
		List <DigitalAccount> digitalAccountsList = digitalAccountService.findAllDigitalAccounts();
		return digitalAccountModelShortAssembler.toCollectionModel(digitalAccountsList);
	}
	
	@Override
	@GetMapping(path = "/{digitalAccountId}")
	public DigitalAccountModelShort findDigitalAccountById(@PathVariable (name = "digitalAccountId", required = true) Long digitalAccountId) {
		DigitalAccount digitalAccount =  digitalAccountService.findDigitalAccountByIdOrFail(digitalAccountId);
		return digitalAccountModelShortAssembler.toModel(digitalAccount);
	}

	
	

}
