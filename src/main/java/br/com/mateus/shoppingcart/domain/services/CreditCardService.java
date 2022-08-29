package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.CreditCardNotFoundException;
import br.com.mateus.shoppingcart.domain.model.CreditCard;
import br.com.mateus.shoppingcart.domain.repositories.CreditCardRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CreditCardService {
		
	@Autowired
	private CreditCardRepository creditCardRepository;
	
	public  List<CreditCard> findAllCreditCards(){
		return creditCardRepository.findAll();
	}
	
	public CreditCard findCreditCardByIdOrFail(Long creditCardId) {
		return creditCardRepository.findById(creditCardId).orElseThrow(() -> new CreditCardNotFoundException(creditCardId));
	}
	

}
