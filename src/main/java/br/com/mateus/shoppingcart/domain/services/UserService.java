package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.UserNotFoundException;
import br.com.mateus.shoppingcart.domain.model.User;
import br.com.mateus.shoppingcart.domain.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UserService {
		
	@Autowired
	private UserRepository userRepository;
	
	public  List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	public User findUserbyIdOrFail(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
	}
	

}
