package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class LegalRepresentativeNotFoundException extends CustomerNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public LegalRepresentativeNotFoundException(Object id) {
		super("Legal Representaitve not found. Id " + id);
	}

}
