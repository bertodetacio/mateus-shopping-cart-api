package br.com.mateus.shoppingcart.domain.exceptions;

public class StockInsufficientQuantityException extends BusinessException {

	private static final long serialVersionUID = 1L;
		
	public StockInsufficientQuantityException(Object storeId, Object productId) {
		super("The stock of Store "+storeId+" does not have the requested quantity of product "+productId);
	}

}
