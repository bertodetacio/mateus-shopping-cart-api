package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class FiscalDocumentNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public FiscalDocumentNotFoundException(Object id) {
		super("Fiscal not found. Id " + id);
	}

}
