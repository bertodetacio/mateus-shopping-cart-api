package br.com.mateus.shoppingcart.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mateus.shoppingcart.domain.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository <Company, Long>{

}
