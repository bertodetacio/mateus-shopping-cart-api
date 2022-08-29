package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.FoodCardController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.FoodCardModelShort;
import br.com.mateus.shoppingcart.domain.model.FoodCard;

@Component
public class FoodCardModelShortAssembler extends RepresentationModelAssemblerSupport<FoodCard, FoodCardModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public FoodCardModelShortAssembler() {
		super(FoodCardController.class, FoodCardModelShort.class);
	}

	@Override
	public FoodCardModelShort toModel(FoodCard foodCard) {
		FoodCardModelShort foodCardModelShort = createModelWithId(foodCard.getId(), foodCard);
		modelMapper.map(foodCard, foodCardModelShort);
		return foodCardModelShort;
	}
	
	public CollectionModel<FoodCardModelShort> toCollectionModel(Iterable<? extends FoodCard> entities) {
		CollectionModel<FoodCardModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
