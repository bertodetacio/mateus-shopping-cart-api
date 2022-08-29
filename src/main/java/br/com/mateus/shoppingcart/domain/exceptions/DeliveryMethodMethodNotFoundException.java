package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class DeliveryMethodMethodNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;

	public DeliveryMethodMethodNotFoundException(Object id) {
		super("DeliveryMethod not found. Id " + id);
	}

}
