package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Data
@EqualsAndHashCode (callSuper = true)
@Relation(collectionRelation = "stocks")
public class StockModelShort extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@NonNull
	@NotNull (message = "Customer cannot be null")
	private StoreModelShort store;
	
	@EqualsAndHashCode.Include
	@NonNull
	@NotNull (message = "Store cannot be null")
	private ProductModelShort product;
	
	@NonNull
	@NotNull (message = "Avaliable Quantity cannot be null")
	private Integer availableQuantity;

	public StockModelShort(StoreModelShort store, ProductModelShort product, Integer availableQuantity) {
		super();
		this.store = store;
		this.product = product;
		this.availableQuantity = availableQuantity;
	}
}
