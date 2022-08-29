package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class UserNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(Object id) {
		super("User not found. Id " + id);
	}

}
