package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class CardNotFoundException extends PaymentObjectNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public CardNotFoundException(Object id) {
		super("Card not found. Id " + id);
	}

}
