package br.com.mateus.shoppingcart.api.exceptionhandlers;

import lombok.Getter;

@Getter
public enum ProblemType {

	RESOURCE_NOT_FOUND("/resource-not-found", "Resource Not Found"),
	STORE_NOT_FOUND("/store-not-found", "Store not found"),
	CUSTOMER_NOT_FOUND("/customer-not-found", "Customer not found"),
	PHROIBITED_OPEN_NEW_CART("/phroibited-open-new-cart", "It is not allowed to open a second cart without having closed the first one."),
	CART_CLOSE("/close-cart", "Close cart"),
	PAYMENT_OBJECT_NOT_FOUND("/payment-not-found", "Payment not found"),
	BUSSINES_ERROR("/business-error", "Business rules violation");
	
	private String title;
	private String uri;
	
	ProblemType(String path, String title) {
		this.uri = "http://matheusplus.com.br" + path;
		this.title = title;
	}
	
}