package br.com.mateus.shoppingcart.api.v1;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.CustomerController;
import br.com.mateus.shoppingcart.api.v1.controllers.ProductController;
import br.com.mateus.shoppingcart.api.v1.controllers.StoreController;

@Component
public class HateoasLinks {

	public Link linkToCustomer(Long customerId, String rel) {
		return linkTo(methodOn(CustomerController.class)
				.findCustomerById(customerId)).withRel(rel);
	}
	
	public Link linkToCustomers(String rel) {
		return linkTo(CustomerController.class).withRel(rel);
	}
	
	
	public Link linkToProduct(Long productId, String rel) {
		return linkTo(methodOn(ProductController.class)
				.findProductById(productId)).withRel(rel);
	}
	
	public Link linkToProducts(String rel) {
		return linkTo(ProductController.class).withRel(rel);
	}
	
	public Link linkToStore(Long storeId, String rel) {
		return linkTo(methodOn(StoreController.class)
				.findStoreById(storeId)).withRel(rel);
	}
	
	public Link linkToStores(String rel) {
		return linkTo(StoreController.class).withRel(rel);
	}


}