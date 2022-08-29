package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class ContractNotFoundException extends PaymentObjectNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public ContractNotFoundException(Object id) {
		super("Contract not found. Id " + id);
	}

}
