package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.FiscalDocumentControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.FiscalDocumentModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.FiscalDocumentModelShort;
import br.com.mateus.shoppingcart.domain.model.FiscalDocument;
import br.com.mateus.shoppingcart.domain.services.FiscalDocumentService;


@RestController
@RequestMapping(path = "api/v1/fiscalDocuments", produces = MediaType.APPLICATION_JSON_VALUE)
public class FiscalDocumentController implements FiscalDocumentControllerOpenApi {
		
	@Autowired
	private FiscalDocumentService fiscalDocumentService;
	
	@Autowired
	private FiscalDocumentModelShortAssembler fiscalDocumentModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<FiscalDocumentModelShort> findAllFiscalDocuments() {
		List <FiscalDocument> fiscalDocumentsList = fiscalDocumentService.findAllsFiscalDocuments();
		return fiscalDocumentModelShortAssembler.toCollectionModel(fiscalDocumentsList);
	}
	
	@Override
	@GetMapping(path = "/{fiscalDocumentId}")
	public FiscalDocumentModelShort findFiscalDocumentById(@PathVariable (name = "fiscalDocumentId", required = true) Long fiscalDocumentId) {
		FiscalDocument fiscalDocument =  fiscalDocumentService.findFiscalDocumentByIdOrFail(fiscalDocumentId);
		return fiscalDocumentModelShortAssembler.toModel(fiscalDocument);
	}

	
	

}
