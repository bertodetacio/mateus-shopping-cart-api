package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class PaymentObjectNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public PaymentObjectNotFoundException(Object id) {
		super("Payment Object not found. Id " + id);
	}

}
