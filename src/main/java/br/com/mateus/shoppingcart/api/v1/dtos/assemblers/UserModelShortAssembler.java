package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.UserController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.UserModelShort;
import br.com.mateus.shoppingcart.domain.model.User;

@Component
public class UserModelShortAssembler extends RepresentationModelAssemblerSupport<User, UserModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public UserModelShortAssembler() {
		super(UserController.class, UserModelShort.class);
	}

	@Override
	public UserModelShort toModel(User carad) {
		UserModelShort caradModelShort = createModelWithId(carad.getId(), carad);
		modelMapper.map(carad, caradModelShort);
		return caradModelShort;
	}
	
	public CollectionModel<UserModelShort> toCollectionModel(Iterable<? extends User> entities) {
		CollectionModel<UserModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
