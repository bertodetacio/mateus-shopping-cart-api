package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class SectorNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public SectorNotFoundException(Object id) {
		super("Sector not found. Id " + id);
	}

}
