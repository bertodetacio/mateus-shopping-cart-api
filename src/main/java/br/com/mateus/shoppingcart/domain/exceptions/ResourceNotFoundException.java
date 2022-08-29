package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public abstract class ResourceNotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;

}
