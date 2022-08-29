package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.CustomerControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.CustomerModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CustomerModelShort;
import br.com.mateus.shoppingcart.domain.model.Customer;
import br.com.mateus.shoppingcart.domain.services.CustomerService;


@RestController
@RequestMapping(path = "api/v1/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController implements CustomerControllerOpenApi {
		
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerModelShortAssembler customerModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<CustomerModelShort> findAllCustomers() {
		List <Customer> customersList = customerService.findAllCustomers();
		return customerModelShortAssembler.toCollectionModel(customersList);
	}
	
	@Override
	@GetMapping(path = "/{customerId}")
	public CustomerModelShort findCustomerById(@PathVariable (name = "customerId", required = true) Long customerId) {
		Customer customer =  customerService.findCustomerByIdOrFail(customerId);
		return customerModelShortAssembler.toModel(customer);
	}

	
	

}
