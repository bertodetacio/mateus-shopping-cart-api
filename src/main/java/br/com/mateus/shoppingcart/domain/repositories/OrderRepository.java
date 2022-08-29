package br.com.mateus.shoppingcart.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mateus.shoppingcart.domain.model.Cart;
import br.com.mateus.shoppingcart.domain.model.Customer;
import br.com.mateus.shoppingcart.domain.model.Order;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long>{
	
	public Order findOrderByCart(Cart cart);
	
	public List<Order> findByCustomer(Customer customer);

}
