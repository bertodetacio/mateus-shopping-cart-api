package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.StoreController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.StoreModelShort;
import br.com.mateus.shoppingcart.domain.model.Store;

@Component
public class StoreModelShortAssembler extends RepresentationModelAssemblerSupport<Store, StoreModelShort> {
	
	@Autowired
	private ModelMapper modelMapper;

	public StoreModelShortAssembler() {
		super(StoreController.class, StoreModelShort.class);
	}

	@Override
	public StoreModelShort toModel(Store store) {
		StoreModelShort storeModel = createModelWithId(store.getId(), store);
		modelMapper.map(store, storeModel);
		return storeModel;
	}
	
	public CollectionModel<StoreModelShort> toCollectionModel(Iterable<? extends Store> entities) {
		CollectionModel<StoreModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
