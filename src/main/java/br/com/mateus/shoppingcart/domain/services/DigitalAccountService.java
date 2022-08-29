package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.DigitalAccountNotFoundException;
import br.com.mateus.shoppingcart.domain.model.DigitalAccount;
import br.com.mateus.shoppingcart.domain.repositories.DigitalAccountRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class DigitalAccountService {
		
	@Autowired
	private DigitalAccountRepository digitalAccountRepository;
	
	public  List<DigitalAccount> findAllDigitalAccounts(){
		return digitalAccountRepository.findAll();
	}
	
	public DigitalAccount findDigitalAccountByIdOrFail(Long digitalAccountId) {
		return digitalAccountRepository.findById(digitalAccountId).orElseThrow(() -> new DigitalAccountNotFoundException(digitalAccountId));
	}
	

}
