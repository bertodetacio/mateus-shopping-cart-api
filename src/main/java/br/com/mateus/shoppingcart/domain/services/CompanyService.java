package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.CompanyNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Company;
import br.com.mateus.shoppingcart.domain.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CompanyService {
		
	@Autowired
	private CompanyRepository companyRepository;
	
	public  List<Company> findAllsCompanies(){
		return companyRepository.findAll();
	}
	
	public Company findCompanyByIdOrFail(Long companyId) {
		return companyRepository.findById(companyId).orElseThrow(() -> new CompanyNotFoundException(companyId));
	}
	

}
