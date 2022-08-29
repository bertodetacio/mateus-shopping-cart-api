package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.StateNotFoundException;
import br.com.mateus.shoppingcart.domain.model.State;
import br.com.mateus.shoppingcart.domain.repositories.StateRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class StateService {
		
	@Autowired
	private StateRepository stateRepository;
	
	public  List<State> findAllStates(){
		return stateRepository.findAll();
	}
	
	public State findStatebyIdOrFail(Long stateId) {
		return stateRepository.findById(stateId).orElseThrow(() -> new StateNotFoundException(stateId));
	}
	

}
