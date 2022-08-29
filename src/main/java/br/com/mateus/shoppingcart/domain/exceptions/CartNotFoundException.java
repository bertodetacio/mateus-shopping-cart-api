package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.NoArgsConstructor;
import lombok.experimental.StandardException;

@NoArgsConstructor
@StandardException
public class CartNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public CartNotFoundException(Object id) {
		super("Cart not found. Id " + id);
	}

}
