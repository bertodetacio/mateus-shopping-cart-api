package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.ItemNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Item;
import br.com.mateus.shoppingcart.domain.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ItemService {
		
	@Autowired
	private ItemRepository itemRepository;
	
	public  List<Item> findAllItems(){
		return itemRepository.findAll();
	}
	
	public Item findItemByIdOrFail(Long itemId) {
		return itemRepository.findById(itemId).orElseThrow(() -> new ItemNotFoundException(itemId));
	}
	

}
