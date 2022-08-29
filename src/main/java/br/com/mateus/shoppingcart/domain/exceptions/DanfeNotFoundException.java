package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.NoArgsConstructor;
import lombok.experimental.StandardException;

@NoArgsConstructor
@StandardException
public class DanfeNotFoundException extends FiscalDocumentNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public DanfeNotFoundException(Object id) {
		super("Danfe not found. Id " + id);
	}

}
