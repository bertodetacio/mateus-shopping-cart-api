package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class CoreBusinessNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public CoreBusinessNotFoundException(Object id) {
		super("Core Business not found. Id " + id);
	}

}
