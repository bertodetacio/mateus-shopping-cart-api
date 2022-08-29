package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class FoodCardNotFoundException extends CardNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public FoodCardNotFoundException(Object id) {
		super("Credit not found. Id " + id);
	}

}
