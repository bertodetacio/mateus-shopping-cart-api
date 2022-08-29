package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.DanfeNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Danfe;
import br.com.mateus.shoppingcart.domain.repositories.DanfeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class DanfeService {
		
	@Autowired
	private DanfeRepository danfeRepository;
	
	public  List<Danfe> findAllDanfes(){
		return danfeRepository.findAll();
	}
	
	public Danfe findDanfeByIdOrFail(Long danfeId) {
		return danfeRepository.findById(danfeId).orElseThrow(() -> new DanfeNotFoundException(danfeId));
	}
	

}
