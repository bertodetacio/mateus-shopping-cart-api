package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class ProductShortageCaseActionException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public ProductShortageCaseActionException(Object id) {
		super("Product Shortage Case Action not found. Code " + id);
	}

}
