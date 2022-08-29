package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.CartControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.CartModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CartModelShort;
import br.com.mateus.shoppingcart.domain.model.Cart;
import br.com.mateus.shoppingcart.domain.services.CartService;


@RestController
@RequestMapping(path = "api/v1/carts", produces = MediaType.APPLICATION_JSON_VALUE)
public class CartController implements CartControllerOpenApi {
		
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartModelShortAssembler cartModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<CartModelShort> findAllCarts() {
		List <Cart> cartsList = cartService.findAllsCarts();
		return cartModelShortAssembler.toCollectionModel(cartsList);
	}
	
	@Override
	@GetMapping(path = "/{cartId}")
	public CartModelShort findCartById(@PathVariable (name = "cartId", required = true) Long cartId) {
		Cart cart =  cartService.findCartByIdOrFail(cartId);
		return cartModelShortAssembler.toModel(cart);
	}

	
	

}
