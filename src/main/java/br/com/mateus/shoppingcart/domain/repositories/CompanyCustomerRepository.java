package br.com.mateus.shoppingcart.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mateus.shoppingcart.domain.model.CustomerCompany;

@Repository
public interface CompanyCustomerRepository extends JpaRepository <CustomerCompany, Long>{

}
