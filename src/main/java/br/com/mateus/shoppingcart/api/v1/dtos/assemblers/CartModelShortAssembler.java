package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.CartController;
import br.com.mateus.shoppingcart.api.v1.controllers.EcommerceController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CartModelShort;
import br.com.mateus.shoppingcart.domain.model.Cart;

@Component
public class CartModelShortAssembler extends RepresentationModelAssemblerSupport<Cart, CartModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public CartModelShortAssembler() {
		super(CartController.class, CartModelShort.class);
	}

	@Override
	public CartModelShort toModel(Cart cart) {
		CartModelShort cartModelShort = createModelWithId(cart.getId(), cart);
		modelMapper.map(cart, cartModelShort);
		return cartModelShort;
	}
	
	public CollectionModel<CartModelShort> toCollectionModel(Iterable<? extends Cart> entities) {
		CollectionModel<CartModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
