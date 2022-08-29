package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.StoreControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.StoreModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.StoreModelShort;
import br.com.mateus.shoppingcart.domain.model.Store;
import br.com.mateus.shoppingcart.domain.services.StoreService;

@RestController
@RequestMapping(path = "api/v1/stores", produces = MediaType.APPLICATION_JSON_VALUE)
public class StoreController implements StoreControllerOpenApi {
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private StoreModelShortAssembler storeModelShortAssembler;
		
	@Override
	@GetMapping(path = "/")
	public CollectionModel<StoreModelShort> findAllStores() {
		List <Store> storesList = storeService.findAllStores();
		return storeModelShortAssembler.toCollectionModel(storesList);
	}
	
	@Override
	@GetMapping(path = "/{storeId}")
	public StoreModelShort findStoreById(@PathVariable (name = "storeId", required = true) Long storeId) {
		Store store =  storeService.findStorebyIdOrFail(storeId);
		return storeModelShortAssembler.toModel(store);
	}

	
	

}
