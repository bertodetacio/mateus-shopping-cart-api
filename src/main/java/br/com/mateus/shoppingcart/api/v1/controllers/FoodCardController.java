package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.FoodCardControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.FoodCardModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.FoodCardModelShort;
import br.com.mateus.shoppingcart.domain.model.FoodCard;
import br.com.mateus.shoppingcart.domain.services.FoodCardService;


@RestController
@RequestMapping(path = "api/v1/foodCards", produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodCardController implements FoodCardControllerOpenApi {
		
	@Autowired
	private FoodCardService foodCardService;
	
	@Autowired
	private FoodCardModelShortAssembler foodCardModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<FoodCardModelShort> findAllFoodCards() {
		List <FoodCard> foodCardsList = foodCardService.findAllFoodCards();
		return foodCardModelShortAssembler.toCollectionModel(foodCardsList);
	}
	
	@Override
	@GetMapping(path = "/{foodCardId}")
	public FoodCardModelShort findFoodCardById(@PathVariable (name = "foodCardId", required = true) Long foodCardId) {
		FoodCard foodCard =  foodCardService.findFoodCardByIdOrFail(foodCardId);
		return foodCardModelShortAssembler.toModel(foodCard);
	}

	
	

}
