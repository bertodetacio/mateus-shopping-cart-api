package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class BrandingNotFoundException extends PaymentObjectNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public BrandingNotFoundException(Object id) {
		super("Card not found. Id " + id);
	}

}
