package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.CityControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.CityModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CityModelShort;
import br.com.mateus.shoppingcart.domain.model.City;
import br.com.mateus.shoppingcart.domain.services.CityService;


@RestController
@RequestMapping(path = "api/v1/cities", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController implements CityControllerOpenApi {
		
	@Autowired
	private CityService cityService;
	
	@Autowired
	private CityModelShortAssembler cityModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<CityModelShort> findAllCities() {
		List <City> citysList = cityService.findAllCities();
		return cityModelShortAssembler.toCollectionModel(citysList);
	}
	
	@Override
	@GetMapping(path = "/{cityId}")
	public CityModelShort findCityById(@PathVariable (name = "cityId", required = true) Long cityId) {
		City city =  cityService.findCityByIdOrFail(cityId);
		return cityModelShortAssembler.toModel(city);
	}

	
	

}
