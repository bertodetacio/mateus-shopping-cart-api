package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.OrderController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.OrderModelShort;
import br.com.mateus.shoppingcart.domain.model.Order;

@Component
public class OrderModelShortAssembler extends RepresentationModelAssemblerSupport<Order, OrderModelShort> {
	
	@Autowired
	private ModelMapper modelMapper;

	public OrderModelShortAssembler() {
		super(OrderController.class, OrderModelShort.class);
	}

	@Override
	public OrderModelShort toModel(Order order) {
		OrderModelShort orderModelShort = null;
		orderModelShort = createModelWithId(order.getId(), order);
		modelMapper.map(order, orderModelShort);
		return orderModelShort;
	}
	
	public CollectionModel<OrderModelShort> toCollectionModel(Iterable<? extends Order> entities) {
		CollectionModel<OrderModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
