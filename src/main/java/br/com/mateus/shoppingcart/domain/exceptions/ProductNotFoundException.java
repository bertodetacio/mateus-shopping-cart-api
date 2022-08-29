package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class ProductNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException(Object id) {
		super("Product not found. Id " + id);
	}

}
