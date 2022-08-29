package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class ShippingMethodNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;

	public ShippingMethodNotFoundException(Object id) {
		super("Shipping Method not found. Id " + id);
	}

}
