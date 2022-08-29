package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.LegalRepresentativeNotFoundException;
import br.com.mateus.shoppingcart.domain.model.LegalRepresentative;
import br.com.mateus.shoppingcart.domain.repositories.LegalRepresentativeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class LegalRepresentativeService {
		
	@Autowired
	private LegalRepresentativeRepository legalRepresentativeRepository;
	
	public  List<LegalRepresentative> findAllsLegalRepresentatives(){
		return legalRepresentativeRepository.findAll();
	}
	
	public LegalRepresentative findLegalRepresentativeByIdOrFail(Long legalRepresentativeId) {
		return legalRepresentativeRepository.findById(legalRepresentativeId).orElseThrow(() -> new LegalRepresentativeNotFoundException(legalRepresentativeId));
	}
	

}
