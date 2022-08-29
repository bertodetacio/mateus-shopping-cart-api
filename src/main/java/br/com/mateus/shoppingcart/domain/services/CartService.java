package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.CartNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Cart;
import br.com.mateus.shoppingcart.domain.repositories.CartRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CartService {
		
	@Autowired
	private CartRepository cartRepository;
	
	public  List<Cart> findAllsCarts(){
		return cartRepository.findAll();
	}
	
	public Cart findCartByIdOrFail(Long cartId) {
		return cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException(cartId));
	}
	

}
