package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.OccupationNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Occupation;
import br.com.mateus.shoppingcart.domain.repositories.OccupationRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class OccupationService {
		
	@Autowired
	private OccupationRepository occupationRepository;
	
	public  List<Occupation> findAllsOccupations(){
		return occupationRepository.findAll();
	}
	
	public Occupation findOccupationByIdOrFail(Long occupationId) {
		return occupationRepository.findById(occupationId).orElseThrow(() -> new OccupationNotFoundException(occupationId));
	}
	

}
