package br.com.mateus.shoppingcart.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mateus.shoppingcart.domain.model.Product;
import br.com.mateus.shoppingcart.domain.model.Stock;
import br.com.mateus.shoppingcart.domain.model.Store;

@Repository
public interface StockRepository extends JpaRepository <Stock, Long>{
	
	public Stock findByStoreAndProduct(Store store, Product product);

}
