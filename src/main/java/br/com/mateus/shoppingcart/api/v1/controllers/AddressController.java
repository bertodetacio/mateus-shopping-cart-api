package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.AddressControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.AddressModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.AddressModelShort;
import br.com.mateus.shoppingcart.domain.model.Address;
import br.com.mateus.shoppingcart.domain.services.AddressService;


@RestController
@RequestMapping(path = "api/v1/addresss", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController implements AddressControllerOpenApi {
		
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private AddressModelShortAssembler addressModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<AddressModelShort> findAllAddresss() {
		List <Address> addresssList = addressService.findAllsAddresss();
		return addressModelShortAssembler.toCollectionModel(addresssList);
	}
	
	@Override
	@GetMapping(path = "/{addressId}")
	public AddressModelShort findAddressById(@PathVariable (name = "addressId", required = true) Long addressId) {
		Address address =  addressService.findAddressByIdOrFail(addressId);
		return addressModelShortAssembler.toModel(address);
	}

	
	

}
