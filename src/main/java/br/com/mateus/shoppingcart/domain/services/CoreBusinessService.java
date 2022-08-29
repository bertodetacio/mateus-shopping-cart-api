package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.CoreBusinessNotFoundException;
import br.com.mateus.shoppingcart.domain.model.CoreBusiness;
import br.com.mateus.shoppingcart.domain.repositories.CoreBusinessRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CoreBusinessService {
		
	@Autowired
	private CoreBusinessRepository coreBusinessRepository;
	
	public  List<CoreBusiness> findAllsCoreBusinesses(){
		return coreBusinessRepository.findAll();
	}
	
	public CoreBusiness findCoreBusinessByIdOrFail(Long coreBusinessId) {
		return coreBusinessRepository.findById(coreBusinessId).orElseThrow(() -> new CoreBusinessNotFoundException(coreBusinessId));
	}
	

}
