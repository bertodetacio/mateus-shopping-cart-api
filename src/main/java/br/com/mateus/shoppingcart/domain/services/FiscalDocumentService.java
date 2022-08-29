package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.FiscalDocumentNotFoundException;
import br.com.mateus.shoppingcart.domain.model.FiscalDocument;
import br.com.mateus.shoppingcart.domain.repositories.FiscalDocumentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class FiscalDocumentService {
		
	@Autowired
	private FiscalDocumentRepository fiscalDocumentRepository;
	
	public  List<FiscalDocument> findAllsFiscalDocuments(){
		return fiscalDocumentRepository.findAll();
	}
	
	public FiscalDocument findFiscalDocumentByIdOrFail(Long fiscalDocumentId) {
		return fiscalDocumentRepository.findById(fiscalDocumentId).orElseThrow(() -> new FiscalDocumentNotFoundException(fiscalDocumentId));
	}
	

}
