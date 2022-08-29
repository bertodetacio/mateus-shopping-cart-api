package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.StateControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.StateModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.StateModelShort;
import br.com.mateus.shoppingcart.domain.model.State;
import br.com.mateus.shoppingcart.domain.services.StateService;


@RestController
@RequestMapping(path = "api/v1/states", produces = MediaType.APPLICATION_JSON_VALUE)
public class StateController implements StateControllerOpenApi {
		
	@Autowired
	private StateService stateService;
	
	@Autowired
	private StateModelShortAssembler stateModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<StateModelShort> findAllStates() {
		List <State> statesList = stateService.findAllStates();
		return stateModelShortAssembler.toCollectionModel(statesList);
	}
	
	@Override
	@GetMapping(path = "/{stateId}")
	public StateModelShort findStateById(@PathVariable (name = "stateId", required = true) Long stateId) {
		State state =  stateService.findStatebyIdOrFail(stateId);
		return stateModelShortAssembler.toModel(state);
	}

	
	

}
