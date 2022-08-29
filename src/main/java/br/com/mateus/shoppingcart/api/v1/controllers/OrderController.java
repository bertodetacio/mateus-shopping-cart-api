package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.OrderControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.OrderModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.OrderModelShort;
import br.com.mateus.shoppingcart.domain.model.Order;
import br.com.mateus.shoppingcart.domain.services.OrderService;


@RestController
@RequestMapping(path = "api/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController implements OrderControllerOpenApi {
		
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderModelShortAssembler orderModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<OrderModelShort> findAllOrders() {
		List <Order> ordersList = orderService.findAllOrders();
		return orderModelShortAssembler.toCollectionModel(ordersList);
	}
	
	@Override
	@GetMapping(path = "/{orderId}")
	public OrderModelShort findOrderById(@PathVariable (name = "orderId", required = true) Long orderId) {
		Order order =  orderService.findOrderByIdOrFail(orderId);
		return orderModelShortAssembler.toModel(order);
	}

	
	

}
