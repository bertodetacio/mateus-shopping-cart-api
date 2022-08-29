package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class InsufficienteBalanceException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	
	public InsufficienteBalanceException() {
		super("The digital account balance is insufficient for this payment");
	}

}
