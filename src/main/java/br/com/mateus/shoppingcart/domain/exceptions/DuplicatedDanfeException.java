package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.NoArgsConstructor;
import lombok.experimental.StandardException;

@NoArgsConstructor
@StandardException
public class DuplicatedDanfeException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	public DuplicatedDanfeException(Object id) {
		super("A Danfe already exists for the informed order. Order id " + id);
	}

}
