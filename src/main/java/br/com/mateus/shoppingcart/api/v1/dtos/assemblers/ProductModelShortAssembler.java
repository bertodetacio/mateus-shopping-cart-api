package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.ProductController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.ProductModelShort;
import br.com.mateus.shoppingcart.domain.model.Product;


@Component
public class ProductModelShortAssembler extends RepresentationModelAssemblerSupport<Product, ProductModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public ProductModelShortAssembler() {
		super(ProductController.class, ProductModelShort.class);
	}

	@Override
	public ProductModelShort toModel(Product product) {
		ProductModelShort productModelShort = createModelWithId(product.getId(), product);
		modelMapper.map(product, productModelShort);
		return productModelShort;
	}
	
	public CollectionModel<ProductModelShort> toCollectionModel(Iterable<? extends Product> entities) {
		CollectionModel<ProductModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
