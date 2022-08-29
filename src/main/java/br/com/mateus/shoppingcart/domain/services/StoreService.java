package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.StoreNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Store;
import br.com.mateus.shoppingcart.domain.repositories.StoreRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class StoreService {
		
	@Autowired
	private StoreRepository storeRepository;
	
	public List<Store> findAllStores(){
		return storeRepository.findAll();
	}
	
	public Store findStorebyIdOrFail(Long storeId) {
		return storeRepository.findById(storeId).orElseThrow(() -> new StoreNotFoundException(storeId));
	}
	

}
