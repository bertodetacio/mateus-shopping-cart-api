package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.ContractController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.ContractModelShort;
import br.com.mateus.shoppingcart.domain.model.Contract;

@Component
public class ContractModelShortAssembler extends RepresentationModelAssemblerSupport<Contract, ContractModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public ContractModelShortAssembler() {
		super(ContractController.class, ContractModelShort.class);
	}

	@Override
	public ContractModelShort toModel(Contract carad) {
		ContractModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<ContractModelShort> toCollectionModel(Iterable<? extends Contract> entities) {
		CollectionModel<ContractModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
