package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class CustomerNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public CustomerNotFoundException(Object id) {
		super("Customer not found. Id " + id);
	}

}
