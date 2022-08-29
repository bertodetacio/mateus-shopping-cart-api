package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.CardNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Card;
import br.com.mateus.shoppingcart.domain.repositories.CardRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CardService {
		
	@Autowired
	private CardRepository cardRepository;
	
	public  List<Card> findAllsCards(){
		return cardRepository.findAll();
	}
	
	public Card findCardByIdOrFail(Long cardId) {
		return cardRepository.findById(cardId).orElseThrow(() -> new CardNotFoundException(cardId));
	}
	

}
