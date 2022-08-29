package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.BusinessAddressNotFoundException;
import br.com.mateus.shoppingcart.domain.model.BusinessAddress;
import br.com.mateus.shoppingcart.domain.repositories.BusinessAddressRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class BusinessAddressService {
		
	@Autowired
	private BusinessAddressRepository businessAddressRepository;
	
	public  List<BusinessAddress> findAllsBusinessAddresss(){
		return businessAddressRepository.findAll();
	}
	
	public BusinessAddress findBusinessAddressByIdOrFail(Long businessAddressId) {
		return businessAddressRepository.findById(businessAddressId).orElseThrow(() -> new BusinessAddressNotFoundException(businessAddressId));
	}
	

}
