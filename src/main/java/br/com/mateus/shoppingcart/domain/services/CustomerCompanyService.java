package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.CustomerCompanyNotFoundException;
import br.com.mateus.shoppingcart.domain.model.CustomerCompany;
import br.com.mateus.shoppingcart.domain.repositories.CompanyCustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CustomerCompanyService {
		
	@Autowired
	private CompanyCustomerRepository companyCustomerRepository;
	
	public CustomerCompany findCompanyCustomerByIdOrFail(Long companyCustomerId) {
		return companyCustomerRepository.findById(companyCustomerId).orElseThrow(() -> new CustomerCompanyNotFoundException(companyCustomerId));
	}

	public List<CustomerCompany> findAllCustomerCompanies() {
		return companyCustomerRepository.findAll();
	}

	
	

}
