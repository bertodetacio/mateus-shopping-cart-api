package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class CreditCardNotFoundException extends CardNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public CreditCardNotFoundException(Object id) {
		super("Credit not found. Id " + id);
	}

}
