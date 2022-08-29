package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.NoArgsConstructor;
import lombok.experimental.StandardException;

@NoArgsConstructor
@StandardException
public class CloseCartException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	public CloseCartException(Object id) {
		super("The shopping cart is closed for adding new products or new checkout. Cart id " + id);
	}

}
