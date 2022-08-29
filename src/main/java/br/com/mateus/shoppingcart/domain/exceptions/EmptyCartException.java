package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.NoArgsConstructor;
import lombok.experimental.StandardException;

@NoArgsConstructor
@StandardException
public class EmptyCartException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	public EmptyCartException(Object id) {
		super("Cart empty. Id " + id);
	}

}
