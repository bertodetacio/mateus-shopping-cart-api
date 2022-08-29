package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class ItemNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public ItemNotFoundException(Object id) {
		super("Item not found. Id " + id);
	}
	
	public ItemNotFoundException(Long cartId, Long productId, Long customerId) {
		super("No items found for cart Id "+cartId+ ", product Id "+productId+ " and customer Id"+customerId);
	}

}
