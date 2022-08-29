package br.com.mateus.shoppingcart.domain.services;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.CustomerNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.DigitalAccountNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.InsufficienteBalanceException;
import br.com.mateus.shoppingcart.domain.model.Customer;
import br.com.mateus.shoppingcart.domain.model.DigitalAccount;
import br.com.mateus.shoppingcart.domain.repositories.CustomerRepository;
import br.com.mateus.shoppingcart.domain.repositories.DigitalAccountRepository;
@Service
public class BankService {
	
	@Autowired
	private DigitalAccountRepository digitalAccountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public boolean payByCreditCard (String cardPrinteName, String cardNumber, String cardexpirationData, String cvv, BigDecimal ammount) {
		return true;
	}
	
	public boolean payByFoodCard (String cardPrinteName, String cardNumber, String cardexpirationData, String cvv, BigDecimal ammount) {
		return true;
	}
	
	public void payByDigitalAccount (Long customerId,  BigDecimal amount) {
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
		DigitalAccount digitalAccount = customer.getDigitalAccount();
		if (digitalAccount == null) {
			throw new DigitalAccountNotFoundException(customer.getId());
		}
		else if (digitalAccount.getBalance().compareTo(amount) == 0
				|| digitalAccount.getBalance().compareTo(amount) == 1) {
			digitalAccount.debit(amount);
			digitalAccountRepository.save(digitalAccount);
		}
		else {
			throw new InsufficienteBalanceException();
		}
	}
	
	public void reverseAmountToDigitalAccount (Long customerId, BigDecimal ammount) {
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
		DigitalAccount digitalAccount = customer.getDigitalAccount();
		if (digitalAccount == null) {
			throw new DigitalAccountNotFoundException(customer.getId());
		}
		else {
			digitalAccount.deposit(ammount);
			digitalAccountRepository.save(digitalAccount);
		}
	}
	
	public String payByPix (BigDecimal ammount) {
		return UUID.randomUUID().toString();
	}

}
