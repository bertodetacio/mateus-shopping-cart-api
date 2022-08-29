package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.NfceNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Nfce;
import br.com.mateus.shoppingcart.domain.repositories.NfceRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class NfceService {
		
	@Autowired
	private NfceRepository nfceRepository;
	
	public  List<Nfce> findAllsNfces(){
		return nfceRepository.findAll();
	}
	
	public Nfce findNfceByIdOrFail(Long nfceId) {
		return nfceRepository.findById(nfceId).orElseThrow(() -> new NfceNotFoundException(nfceId));
	}
	

}
