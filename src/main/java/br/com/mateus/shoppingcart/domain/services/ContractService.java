package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.ContractNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Contract;
import br.com.mateus.shoppingcart.domain.repositories.ContractRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ContractService {
		
	@Autowired
	private ContractRepository contractRepository;
	
	public  List<Contract> findAllsContracts(){
		return contractRepository.findAll();
	}
	
	public Contract findContractByIdOrFail(Long contractId) {
		return contractRepository.findById(contractId).orElseThrow(() -> new ContractNotFoundException(contractId));
	}
	

}
