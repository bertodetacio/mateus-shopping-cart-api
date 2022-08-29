package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.LegalRepresentativeControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.LegalRepresentativeModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.LegalRepresentativeModelShort;
import br.com.mateus.shoppingcart.domain.model.LegalRepresentative;
import br.com.mateus.shoppingcart.domain.services.LegalRepresentativeService;


@RestController
@RequestMapping(path = "api/v1/legalRepresentatives", produces = MediaType.APPLICATION_JSON_VALUE)
public class LegalRepresentativeController implements LegalRepresentativeControllerOpenApi {
		
	@Autowired
	private LegalRepresentativeService legalRepresentativeService;
	
	@Autowired
	private LegalRepresentativeModelShortAssembler legalRepresentativeModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<LegalRepresentativeModelShort> findAllLegalRepresentatives() {
		List <LegalRepresentative> legalRepresentativesList = legalRepresentativeService.findAllsLegalRepresentatives();
		return legalRepresentativeModelShortAssembler.toCollectionModel(legalRepresentativesList);
	}
	
	@Override
	@GetMapping(path = "/{legalRepresentativeId}")
	public LegalRepresentativeModelShort findLegalRepresentativeById(@PathVariable (name = "legalRepresentativeId", required = true) Long legalRepresentativeId) {
		LegalRepresentative legalRepresentative =  legalRepresentativeService.findLegalRepresentativeByIdOrFail(legalRepresentativeId);
		return legalRepresentativeModelShortAssembler.toModel(legalRepresentative);
	}

	
	

}
