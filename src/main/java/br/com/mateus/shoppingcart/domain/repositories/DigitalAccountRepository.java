package br.com.mateus.shoppingcart.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mateus.shoppingcart.domain.model.DigitalAccount;

@Repository
public interface DigitalAccountRepository extends JpaRepository <DigitalAccount, Long>{

}
