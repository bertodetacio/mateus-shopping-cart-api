package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.NoArgsConstructor;
import lombok.experimental.StandardException;

@NoArgsConstructor
@StandardException
public class DeliveryAddressNotFoundNotFoundException extends AddressNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public DeliveryAddressNotFoundNotFoundException(Object id) {
		super("Delivery Address not found. Id " + id);
	}

}
