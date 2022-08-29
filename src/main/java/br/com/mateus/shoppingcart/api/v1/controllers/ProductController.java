package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.ProductControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.ProductModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.ProductModelShort;
import br.com.mateus.shoppingcart.domain.model.Product;
import br.com.mateus.shoppingcart.domain.services.ProductService;

@RestController
@RequestMapping(path = "api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController implements ProductControllerOpenApi {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductModelShortAssembler productModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<ProductModelShort> findAllProducts() {
		List <Product> productsList = productService.findAllProducts();
		return productModelShortAssembler.toCollectionModel(productsList);
	}
	
	@Override
	@GetMapping(path = "/{productId}")
	public ProductModelShort findProductById(@PathVariable (name = "productId", required = true) Long productId) {
		Product product =  productService.findProductByIdOrFail(productId);
		return productModelShortAssembler.toModel(product);
	}

	
	

}
