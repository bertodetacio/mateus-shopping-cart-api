package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class CategoryNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public CategoryNotFoundException(Object id) {
		super("Category not found. Id " + id);
	}

}
