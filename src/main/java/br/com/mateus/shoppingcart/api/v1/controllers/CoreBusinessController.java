package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.CoreBusinessControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.CoreBusinessModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CoreBusinessModelShort;
import br.com.mateus.shoppingcart.domain.model.CoreBusiness;
import br.com.mateus.shoppingcart.domain.services.CoreBusinessService;


@RestController
@RequestMapping(path = "api/v1/coreBusinesss", produces = MediaType.APPLICATION_JSON_VALUE)
public class CoreBusinessController implements CoreBusinessControllerOpenApi {
		
	@Autowired
	private CoreBusinessService coreBusinessService;
	
	@Autowired
	private CoreBusinessModelShortAssembler coreBusinessModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<CoreBusinessModelShort> findAllCoreBusinesses() {
		List <CoreBusiness> coreBusinesssList = coreBusinessService.findAllsCoreBusinesses();
		return coreBusinessModelShortAssembler.toCollectionModel(coreBusinesssList);
	}
	
	@Override
	@GetMapping(path = "/{coreBusinessId}")
	public CoreBusinessModelShort findCoreBusinessById(@PathVariable (name = "coreBusinessId", required = true) Long coreBusinessId) {
		CoreBusiness coreBusiness =  coreBusinessService.findCoreBusinessByIdOrFail(coreBusinessId);
		return coreBusinessModelShortAssembler.toModel(coreBusiness);
	}

	
	

}
