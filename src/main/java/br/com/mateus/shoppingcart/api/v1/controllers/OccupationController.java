package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.OccupationControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.OccupationModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.OccupationModelShort;
import br.com.mateus.shoppingcart.domain.model.Occupation;
import br.com.mateus.shoppingcart.domain.services.OccupationService;


@RestController
@RequestMapping(path = "api/v1/occupations", produces = MediaType.APPLICATION_JSON_VALUE)
public class OccupationController implements OccupationControllerOpenApi {
		
	@Autowired
	private OccupationService occupationService;
	
	@Autowired
	private OccupationModelShortAssembler occupationModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<OccupationModelShort> findAllOccupations() {
		List <Occupation> occupationsList = occupationService.findAllsOccupations();
		return occupationModelShortAssembler.toCollectionModel(occupationsList);
	}
	
	@Override
	@GetMapping(path = "/{occupationId}")
	public OccupationModelShort findOccupationById(@PathVariable (name = "occupationId", required = true) Long occupationId) {
		Occupation occupation =  occupationService.findOccupationByIdOrFail(occupationId);
		return occupationModelShortAssembler.toModel(occupation);
	}

	
	

}
