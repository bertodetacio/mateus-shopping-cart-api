package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.hateoas.server.core.Relation;

import br.com.mateus.shoppingcart.api.v1.dtos.model.enums.CartStatusModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode (callSuper = true)
@ToString (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "carts")
public class CartModelShort extends BaseModelShort  {
	
	private static final long serialVersionUID = 1L;
	
	private CartStatusModel cartStatus;
	
	private StoreModelShort store;
	
	private CustomerModelShort customer;
	
	private Set<ItemModelShort> items = new HashSet<ItemModelShort>();

}
