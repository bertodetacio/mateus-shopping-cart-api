package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.ItemController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.ItemModelShort;
import br.com.mateus.shoppingcart.domain.model.Item;

@Component
public class ItemModelShortAssembler extends RepresentationModelAssemblerSupport<Item, ItemModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public ItemModelShortAssembler() {
		super(ItemController.class, ItemModelShort.class);
	}

	@Override
	public ItemModelShort toModel(Item carad) {
		ItemModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<ItemModelShort> toCollectionModel(Iterable<? extends Item> entities) {
		CollectionModel<ItemModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
