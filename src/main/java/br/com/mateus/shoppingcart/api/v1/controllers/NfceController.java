package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.NfceControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.NfceModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.NfceModelShort;
import br.com.mateus.shoppingcart.domain.model.Nfce;
import br.com.mateus.shoppingcart.domain.services.NfceService;


@RestController
@RequestMapping(path = "api/v1/nfces", produces = MediaType.APPLICATION_JSON_VALUE)
public class NfceController implements NfceControllerOpenApi {
		
	@Autowired
	private NfceService nfceService;
	
	@Autowired
	private NfceModelShortAssembler nfceModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<NfceModelShort> findAllNfces() {
		List <Nfce> nfcesList = nfceService.findAllsNfces();
		return nfceModelShortAssembler.toCollectionModel(nfcesList);
	}
	
	@Override
	@GetMapping(path = "/{nfceId}")
	public NfceModelShort findNfceById(@PathVariable (name = "nfceId", required = true) Long nfceId) {
		Nfce nfce =  nfceService.findNfceByIdOrFail(nfceId);
		return nfceModelShortAssembler.toModel(nfce);
	}

	
	

}
