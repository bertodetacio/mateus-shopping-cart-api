package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.IndividualCustomerNotFoundException;
import br.com.mateus.shoppingcart.domain.model.IndividualCustomer;
import br.com.mateus.shoppingcart.domain.repositories.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class IndividualCustomerService {
		
	@Autowired
	private IndividualCustomerRepository individualCustomerRepository;
	
	public List<IndividualCustomer> findAllsIndividualCustomers(){
		return individualCustomerRepository.findAll();
	}
	
	public IndividualCustomer findIndividualCustomerByIdOrFail(Long individualCustomerId) {
		return individualCustomerRepository.findById(individualCustomerId).orElseThrow(() -> new IndividualCustomerNotFoundException(individualCustomerId));
	}
	

}
