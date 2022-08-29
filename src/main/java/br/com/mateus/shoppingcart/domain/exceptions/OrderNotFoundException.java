package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.NoArgsConstructor;
import lombok.experimental.StandardException;

@NoArgsConstructor
@StandardException
public class OrderNotFoundException extends ResourceNotFoundException{

	private static final long serialVersionUID = 1L;
	
	public OrderNotFoundException(Object id) {
		super("Order not found. Id "+ id);
	}

}
