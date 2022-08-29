package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.CustomerNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Customer;
import br.com.mateus.shoppingcart.domain.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CustomerService {
		
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> findAllCustomers(){
		return customerRepository.findAll();
	}
	
	public Customer findCustomerByIdOrFail(Long customerId) {
		return customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
	}
	

}
