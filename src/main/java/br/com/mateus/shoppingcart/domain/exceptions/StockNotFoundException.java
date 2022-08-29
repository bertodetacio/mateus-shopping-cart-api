package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class StockNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public StockNotFoundException(Object id) {
		super("Stock not found. Id " + id);
	}

}
