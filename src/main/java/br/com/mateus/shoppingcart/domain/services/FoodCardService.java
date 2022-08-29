package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.FoodCardNotFoundException;
import br.com.mateus.shoppingcart.domain.model.FoodCard;
import br.com.mateus.shoppingcart.domain.repositories.FoodCardRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class FoodCardService {
		
	@Autowired
	private FoodCardRepository foodCardRepository;
	
	public  List<FoodCard> findAllFoodCards(){
		return foodCardRepository.findAll();
	}
	
	public FoodCard findFoodCardByIdOrFail(Long foodCardId) {
		return foodCardRepository.findById(foodCardId).orElseThrow(() -> new FoodCardNotFoundException(foodCardId));
	}
	

}
