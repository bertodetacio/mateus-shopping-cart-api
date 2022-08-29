package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.SectionNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Section;
import br.com.mateus.shoppingcart.domain.repositories.SectionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class SectionService {
		
	@Autowired
	private SectionRepository sectionRepository;
	
	public  List<Section> findAllSections(){
		return sectionRepository.findAll();
	}
	
	public Section findSectionByIdOrFail(Long sectionId) {
		return sectionRepository.findById(sectionId).orElseThrow(() -> new SectionNotFoundException(sectionId));
	}
	

}
