package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.io.Serializable;

import org.springframework.hateoas.server.core.Relation;

import br.com.mateus.shoppingcart.api.v1.dtos.model.enums.CartStatusModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "carts")
public class CartModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Schema(example = "1")
	private CartStatusModel cartStatus;
	
	@Schema(example = "1")
	private StoreModel store;
	
	@Schema(example = "1")
	private CustomerModel customer;
	
	

}
