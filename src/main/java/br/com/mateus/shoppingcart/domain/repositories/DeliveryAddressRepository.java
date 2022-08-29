package br.com.mateus.shoppingcart.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mateus.shoppingcart.domain.model.DeliveryAddress;

@Repository
public interface DeliveryAddressRepository extends JpaRepository <DeliveryAddress, Long>{

}
