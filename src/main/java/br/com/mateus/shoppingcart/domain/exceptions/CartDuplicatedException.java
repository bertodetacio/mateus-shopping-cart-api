package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class CartDuplicatedException extends BusinessException {

	private static final long serialVersionUID = 1L;
		
	public CartDuplicatedException() {
		super("It is not allowed to open a second cart without having closed the first one.");
	}

}
