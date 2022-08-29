package br.com.mateus.shoppingcart.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mateus.shoppingcart.domain.model.Cart;
import br.com.mateus.shoppingcart.domain.model.Item;
import br.com.mateus.shoppingcart.domain.model.Product;

@Repository
public interface ItemRepository extends JpaRepository <Item, Long>{
	
	public Item findByProductAndCart(Product product, Cart cart);

}
