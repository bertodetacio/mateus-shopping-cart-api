package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class StateNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public StateNotFoundException(Object id) {
		super("State not found. Id " + id);
	}

}
