package br.com.mateus.shoppingcart.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mateus.shoppingcart.domain.model.Customer;
import br.com.mateus.shoppingcart.domain.model.Danfe;
import br.com.mateus.shoppingcart.domain.model.Order;

@Repository
public interface DanfeRepository extends JpaRepository <Danfe, Long>{
	
	public Danfe findByOrder(Order order);
	
	public List<Danfe> findByCustomer (Customer customer);

}
