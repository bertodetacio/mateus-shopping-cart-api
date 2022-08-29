package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.CategoryController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CategoryModelShort;
import br.com.mateus.shoppingcart.domain.model.Category;

@Component
public class CategoryModelShortAssembler extends RepresentationModelAssemblerSupport<Category, CategoryModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public CategoryModelShortAssembler() {
		super(CategoryController.class, CategoryModelShort.class);
	}

	@Override
	public CategoryModelShort toModel(Category carad) {
		CategoryModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<CategoryModelShort> toCollectionModel(Iterable<? extends Category> entities) {
		CollectionModel<CategoryModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
