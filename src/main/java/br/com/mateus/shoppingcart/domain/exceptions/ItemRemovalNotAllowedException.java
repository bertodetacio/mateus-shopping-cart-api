package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class ItemRemovalNotAllowedException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public ItemRemovalNotAllowedException() {
		super("Cannot remove an item associated with an order or closed cart");
	}

}
