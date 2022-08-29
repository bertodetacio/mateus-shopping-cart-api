package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.NoArgsConstructor;
import lombok.experimental.StandardException;

@NoArgsConstructor
@StandardException
public class DepartmentNotFoundException extends SectorNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public DepartmentNotFoundException(Object id) {
		super("Department not found. Id " + id);
	}

}
