package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class IndividualCustomerNotFoundException extends CustomerNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public IndividualCustomerNotFoundException(Object id) {
		super("Individual Customer not found. Id " + id);
	}

}
