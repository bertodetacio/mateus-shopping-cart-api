package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class BusinessAddressNotFoundException extends AddressNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public BusinessAddressNotFoundException(Object id) {
		super("Business Address not found. Id " + id);
	}

}
