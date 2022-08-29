package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.ContractControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.ContractModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.ContractModelShort;
import br.com.mateus.shoppingcart.domain.model.Contract;
import br.com.mateus.shoppingcart.domain.services.ContractService;


@RestController
@RequestMapping(path = "api/v1/contracts", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContractController implements ContractControllerOpenApi {
		
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private ContractModelShortAssembler contractModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<ContractModelShort> findAllContracts() {
		List <Contract> contractsList = contractService.findAllsContracts();
		return contractModelShortAssembler.toCollectionModel(contractsList);
	}
	
	@Override
	@GetMapping(path = "/{contractId}")
	public ContractModelShort findContractById(@PathVariable (name = "contractId", required = true) Long contractId) {
		Contract contract =  contractService.findContractByIdOrFail(contractId);
		return contractModelShortAssembler.toModel(contract);
	}

	
	

}
