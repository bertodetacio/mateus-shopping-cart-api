package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.AddressNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Address;
import br.com.mateus.shoppingcart.domain.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class AddressService {
		
	@Autowired
	private AddressRepository addressRepository;
	
	public  List<Address> findAllsAddresss(){
		return addressRepository.findAll();
	}
	
	public Address findAddressByIdOrFail(Long addressId) {
		return addressRepository.findById(addressId).orElseThrow(() -> new AddressNotFoundException(addressId));
	}
	

}
