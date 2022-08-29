package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.CustomerCompanyControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.CustomerCompanyModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CustomerCompanyModelShort;
import br.com.mateus.shoppingcart.domain.model.CustomerCompany;
import br.com.mateus.shoppingcart.domain.services.CustomerCompanyService;


@RestController
@RequestMapping(path = "api/v1/customerCompanys", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerCompanyController implements CustomerCompanyControllerOpenApi {
		
	@Autowired
	private CustomerCompanyService customerCompanyService;
	
	@Autowired
	private CustomerCompanyModelShortAssembler customerCompanyModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<CustomerCompanyModelShort> findAllCustomerCompanies() {
		List <CustomerCompany> customerCompanysList = customerCompanyService.findAllCustomerCompanies();
		return customerCompanyModelShortAssembler.toCollectionModel(customerCompanysList);
	}
	
	@Override
	@GetMapping(path = "/{customerCompanyId}")
	public CustomerCompanyModelShort findCustomerCompanyById(@PathVariable (name = "customerCompanyId", required = true) Long customerCompanyId) {
		CustomerCompany customerCompany =  customerCompanyService.findCompanyCustomerByIdOrFail(customerCompanyId);
		return customerCompanyModelShortAssembler.toModel(customerCompany);
	}

	
	

}
