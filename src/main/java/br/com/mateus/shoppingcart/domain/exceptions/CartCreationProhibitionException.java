package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.NoArgsConstructor;
import lombok.experimental.StandardException;

@NoArgsConstructor
@StandardException
public class CartCreationProhibitionException extends BusinessException {

	private static final long serialVersionUID = 1L;
		
	public CartCreationProhibitionException(Object id) {
		super("Cart is close for new products. Id " + id+ ". A new cart must be opened");
	}

}
