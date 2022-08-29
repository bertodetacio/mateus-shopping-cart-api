package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class DigitalAccountNotFoundException extends PaymentObjectNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public DigitalAccountNotFoundException(Object id) {
		super("Digital account not found for the customer Id " + id);
	}

}
