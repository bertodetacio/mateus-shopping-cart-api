package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.IndividualCustomerControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.IndividualCustomerModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.IndividualCustomerModelShort;
import br.com.mateus.shoppingcart.domain.model.IndividualCustomer;
import br.com.mateus.shoppingcart.domain.services.IndividualCustomerService;


@RestController
@RequestMapping(path = "api/v1/individualCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
public class IndividualCustomerController implements IndividualCustomerControllerOpenApi {
		
	@Autowired
	private IndividualCustomerService individualCustomerService;
	
	@Autowired
	private IndividualCustomerModelShortAssembler individualCustomerModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<IndividualCustomerModelShort> findAllIndividualCustomers() {
		List <IndividualCustomer> individualCustomersList = individualCustomerService.findAllsIndividualCustomers();
		return individualCustomerModelShortAssembler.toCollectionModel(individualCustomersList);
	}
	
	@Override
	@GetMapping(path = "/{individualCustomerId}")
	public IndividualCustomerModelShort findIndividualCustomerById(@PathVariable (name = "individualCustomerId", required = true) Long individualCustomerId) {
		IndividualCustomer individualCustomer =  individualCustomerService.findIndividualCustomerByIdOrFail(individualCustomerId);
		return individualCustomerModelShortAssembler.toModel(individualCustomer);
	}

	
	

}
