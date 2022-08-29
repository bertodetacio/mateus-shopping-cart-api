package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class OccupationNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public OccupationNotFoundException(Object id) {
		super("Occupation not found. Id " + id);
	}

}
