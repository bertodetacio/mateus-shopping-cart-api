package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class PersonNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public PersonNotFoundException(Object id) {
		super("Person not found. Id " + id);
	}

}
