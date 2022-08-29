package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.SectorNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Sector;
import br.com.mateus.shoppingcart.domain.repositories.SectorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class SectorService {
		
	@Autowired
	private SectorRepository sectorRepository;
	
	public  List<Sector> findAllsSectors(){
		return sectorRepository.findAll();
	}
	
	public Sector findSectorByIdOrFail(Long sectorId) {
		return sectorRepository.findById(sectorId).orElseThrow(() -> new SectorNotFoundException(sectorId));
	}
	

}
