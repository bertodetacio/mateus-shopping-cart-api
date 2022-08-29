package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.BrandingControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.BrandingModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.BrandingModelShort;
import br.com.mateus.shoppingcart.domain.model.Branding;
import br.com.mateus.shoppingcart.domain.services.BrandingService;


@RestController
@RequestMapping(path = "api/v1/brandings", produces = MediaType.APPLICATION_JSON_VALUE)
public class BrandingController implements BrandingControllerOpenApi {
		
	@Autowired
	private BrandingService brandingService;
	
	@Autowired
	private BrandingModelShortAssembler brandingModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<BrandingModelShort> findAllBrandings() {
		List <Branding> brandingsList = brandingService.findAllsBrandings();
		return brandingModelShortAssembler.toCollectionModel(brandingsList);
	}
	
	@Override
	@GetMapping(path = "/{brandingId}")
	public BrandingModelShort findBrandingById(@PathVariable (name = "brandingId", required = true) Long brandingId) {
		Branding branding =  brandingService.findBrandingByIdOrFail(brandingId);
		return brandingModelShortAssembler.toModel(branding);
	}

	
	

}
