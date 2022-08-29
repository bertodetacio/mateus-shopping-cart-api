package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.DanfeControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.DanfeModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.DanfeModelShort;
import br.com.mateus.shoppingcart.domain.model.Danfe;
import br.com.mateus.shoppingcart.domain.services.DanfeService;


@RestController
@RequestMapping(path = "api/v1/danfes", produces = MediaType.APPLICATION_JSON_VALUE)
public class DanfeController implements DanfeControllerOpenApi {
		
	@Autowired
	private DanfeService danfeService;
	
	@Autowired
	private DanfeModelShortAssembler danfeModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<DanfeModelShort> findAllDanfes() {
		List <Danfe> danfesList = danfeService.findAllDanfes();
		return danfeModelShortAssembler.toCollectionModel(danfesList);
	}
	
	@Override
	@GetMapping(path = "/{danfeId}")
	public DanfeModelShort findDanfeById(@PathVariable (name = "danfeId", required = true) Long danfeId) {
		Danfe danfe =  danfeService.findDanfeByIdOrFail(danfeId);
		return danfeModelShortAssembler.toModel(danfe);
	}

	
	

}
