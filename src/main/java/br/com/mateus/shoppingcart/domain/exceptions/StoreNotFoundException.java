package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class StoreNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public StoreNotFoundException(Object id) {
		super("Store not found. Id " + id);
	}

}
