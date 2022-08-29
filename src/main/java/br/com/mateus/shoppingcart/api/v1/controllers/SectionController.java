package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.SectionControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.SectionModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.SectionModelShort;
import br.com.mateus.shoppingcart.domain.model.Section;
import br.com.mateus.shoppingcart.domain.services.SectionService;


@RestController
@RequestMapping(path = "api/v1/sections", produces = MediaType.APPLICATION_JSON_VALUE)
public class SectionController implements SectionControllerOpenApi {
		
	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private SectionModelShortAssembler sectionModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<SectionModelShort> findAllSections() {
		List <Section> sectionsList = sectionService.findAllSections();
		return sectionModelShortAssembler.toCollectionModel(sectionsList);
	}
	
	@Override
	@GetMapping(path = "/{sectionId}")
	public SectionModelShort findSectionById(@PathVariable (name = "sectionId", required = true) Long sectionId) {
		Section section =  sectionService.findSectionByIdOrFail(sectionId);
		return sectionModelShortAssembler.toModel(section);
	}

	
	

}
