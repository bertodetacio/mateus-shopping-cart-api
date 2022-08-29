package br.com.mateus.shoppingcart.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mateus.shoppingcart.domain.model.IndividualCustomer;

@Repository
public interface IndividualCustomerRepository extends JpaRepository <IndividualCustomer, Long>{

}
