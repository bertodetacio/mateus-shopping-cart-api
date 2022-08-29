package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.BusinessAddressControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.BusinessAddressModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.BusinessAddressModelShort;
import br.com.mateus.shoppingcart.domain.model.BusinessAddress;
import br.com.mateus.shoppingcart.domain.services.BusinessAddressService;


@RestController
@RequestMapping(path = "api/v1/businessAddresss", produces = MediaType.APPLICATION_JSON_VALUE)
public class BusinessAddressController implements BusinessAddressControllerOpenApi {
		
	@Autowired
	private BusinessAddressService businessAddressService;
	
	@Autowired
	private BusinessAddressModelShortAssembler businessAddressModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<BusinessAddressModelShort> findAllBusinessAddresss() {
		List <BusinessAddress> businessAddresssList = businessAddressService.findAllsBusinessAddresss();
		return businessAddressModelShortAssembler.toCollectionModel(businessAddresssList);
	}
	
	@Override
	@GetMapping(path = "/{businessAddressId}")
	public BusinessAddressModelShort findBusinessAddressById(@PathVariable (name = "businessAddressId", required = true) Long businessAddressId) {
		BusinessAddress businessAddress =  businessAddressService.findBusinessAddressByIdOrFail(businessAddressId);
		return businessAddressModelShortAssembler.toModel(businessAddress);
	}

	
	

}
