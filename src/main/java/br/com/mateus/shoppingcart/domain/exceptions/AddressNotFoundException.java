package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class AddressNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public AddressNotFoundException(Object id) {
		super("Address not found. Id " + id);
	}

}
