package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class CityNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public CityNotFoundException(Object id) {
		super("City not found. Id " + id);
	}

}
