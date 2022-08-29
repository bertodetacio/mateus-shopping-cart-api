package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.StateController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.StateModelShort;
import br.com.mateus.shoppingcart.domain.model.State;

@Component
public class StateModelShortAssembler extends RepresentationModelAssemblerSupport<State, StateModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public StateModelShortAssembler() {
		super(StateController.class, StateModelShort.class);
	}

	@Override
	public StateModelShort toModel(State carad) {
		StateModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<StateModelShort> toCollectionModel(Iterable<? extends State> entities) {
		CollectionModel<StateModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
