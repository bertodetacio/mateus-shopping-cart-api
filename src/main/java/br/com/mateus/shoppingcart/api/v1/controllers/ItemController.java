package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.ItemControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.ItemModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.ItemModelShort;
import br.com.mateus.shoppingcart.domain.model.Item;
import br.com.mateus.shoppingcart.domain.services.ItemService;


@RestController
@RequestMapping(path = "api/v1/items", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController implements ItemControllerOpenApi {
		
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemModelShortAssembler itemModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<ItemModelShort> findAllItems() {
		List <Item> itemsList = itemService.findAllItems();
		return itemModelShortAssembler.toCollectionModel(itemsList);
	}
	
	@Override
	@GetMapping(path = "/{itemId}")
	public ItemModelShort findItemById(@PathVariable (name = "itemId", required = true) Long itemId) {
		Item item =  itemService.findItemByIdOrFail(itemId);
		return itemModelShortAssembler.toModel(item);
	}

	
	

}
