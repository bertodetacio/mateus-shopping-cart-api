package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.SectorControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.SectorModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.SectorModelShort;
import br.com.mateus.shoppingcart.domain.model.Sector;
import br.com.mateus.shoppingcart.domain.services.SectorService;


@RestController
@RequestMapping(path = "api/v1/sectors", produces = MediaType.APPLICATION_JSON_VALUE)
public class SectorController implements SectorControllerOpenApi {
		
	@Autowired
	private SectorService sectorService;
	
	@Autowired
	private SectorModelShortAssembler sectorModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<SectorModelShort> findAllSectors() {
		List <Sector> sectorsList = sectorService.findAllsSectors();
		return sectorModelShortAssembler.toCollectionModel(sectorsList);
	}
	
	@Override
	@GetMapping(path = "/{sectorId}")
	public SectorModelShort findSectorById(@PathVariable (name = "sectorId", required = true) Long sectorId) {
		Sector sector =  sectorService.findSectorByIdOrFail(sectorId);
		return sectorModelShortAssembler.toModel(sector);
	}

	
	

}
