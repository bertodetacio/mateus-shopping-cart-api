package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.CategoryControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.CategoryModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CategoryModelShort;
import br.com.mateus.shoppingcart.domain.model.Category;
import br.com.mateus.shoppingcart.domain.services.CategoryService;


@RestController
@RequestMapping(path = "api/v1/categories", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController implements CategoryControllerOpenApi {
		
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryModelShortAssembler categoryModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<CategoryModelShort> findAllCategories() {
		List <Category> categorysList = categoryService.findAllsCategorys();
		return categoryModelShortAssembler.toCollectionModel(categorysList);
	}
	
	@Override
	@GetMapping(path = "/{categoryId}")
	public CategoryModelShort findCategoryById(@PathVariable (name = "categoryId", required = true) Long categoryId) {
		Category category =  categoryService.findCategoryByIdOrFail(categoryId);
		return categoryModelShortAssembler.toModel(category);
	}

	
	

}
