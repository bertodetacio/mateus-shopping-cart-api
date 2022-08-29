package br.com.mateus.shoppingcart.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mateus.shoppingcart.domain.model.Cart;
import br.com.mateus.shoppingcart.domain.model.Customer;
import br.com.mateus.shoppingcart.domain.model.Store;
import br.com.mateus.shoppingcart.domain.model.enums.CartStatus;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	public Cart findByStoreAndCustomerAndCartStatus(Store store, Customer customer, CartStatus cartStatus);

	public List<Cart> findByCustomer(Customer customer);

}
