package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.BrandingNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Branding;
import br.com.mateus.shoppingcart.domain.repositories.BrandingRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class BrandingService {
		
	@Autowired
	private BrandingRepository brandingRepository;
	
	public  List<Branding> findAllsBrandings(){
		return brandingRepository.findAll();
	}
	
	public Branding findBrandingByIdOrFail(Long brandingId) {
		return brandingRepository.findById(brandingId).orElseThrow(() -> new BrandingNotFoundException(brandingId));
	}
	

}
