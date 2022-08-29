package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.UserControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.UserModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.UserModelShort;
import br.com.mateus.shoppingcart.domain.model.User;
import br.com.mateus.shoppingcart.domain.services.UserService;


@RestController
@RequestMapping(path = "api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController implements UserControllerOpenApi {
		
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserModelShortAssembler userModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<UserModelShort> findAllUsers() {
		List <User> usersList = userService.findAllUsers();
		return userModelShortAssembler.toCollectionModel(usersList);
	}
	
	@Override
	@GetMapping(path = "/{userId}")
	public UserModelShort findUserById(@PathVariable (name = "userId", required = true) Long userId) {
		User user =  userService.findUserbyIdOrFail(userId);
		return userModelShortAssembler.toModel(user);
	}

	
	

}
