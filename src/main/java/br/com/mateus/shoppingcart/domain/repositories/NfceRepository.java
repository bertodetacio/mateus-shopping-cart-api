package br.com.mateus.shoppingcart.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mateus.shoppingcart.domain.model.Customer;
import br.com.mateus.shoppingcart.domain.model.Nfce;
import br.com.mateus.shoppingcart.domain.model.Order;

@Repository
public interface NfceRepository extends JpaRepository <Nfce, Long>{
	
	public List<Nfce> findByCustomer (Customer customer);
	
	public Nfce findByOrder (Order order);

}
