package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.CompanyControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.CompanyModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CompanyModelShort;
import br.com.mateus.shoppingcart.domain.model.Company;
import br.com.mateus.shoppingcart.domain.services.CompanyService;


@RestController
@RequestMapping(path = "api/v1/companies", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyController implements CompanyControllerOpenApi {
		
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CompanyModelShortAssembler companyModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<CompanyModelShort> findAllCompanies() {
		List <Company> companysList = companyService.findAllsCompanies();
		return companyModelShortAssembler.toCollectionModel(companysList);
	}
	
	@Override
	@GetMapping(path = "/{companyId}")
	public CompanyModelShort findCompanyById(@PathVariable (name = "companyId", required = true) Long companyId) {
		Company company =  companyService.findCompanyByIdOrFail(companyId);
		return companyModelShortAssembler.toModel(company);
	}

	
	

}
