package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.OrderNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Order;
import br.com.mateus.shoppingcart.domain.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class OrderService {
		
	@Autowired
	private OrderRepository porderRepository;
	
	public List<Order> findAllOrders(){
		return porderRepository.findAll();
	}
	
	public Order findOrderByIdOrFail(Long porderId) {
		return porderRepository.findById(porderId).orElseThrow(() -> new OrderNotFoundException(porderId));
	}
	

}
