package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.server.core.Relation;

import br.com.mateus.shoppingcart.api.v1.dtos.model.pk.StoreProductPKModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Data
@EqualsAndHashCode (callSuper = true)
@Relation(collectionRelation = "stocks")
public class StockModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@EmbeddedId
	private final StoreProductPKModel storePKModel = new StoreProductPKModel();

	@EqualsAndHashCode.Include
	@NonNull
	@NotNull (message = "Customer cannot be null")
	private StoreModel store;
	
	@EqualsAndHashCode.Include
	@NonNull
	@NotNull (message = "Store cannot be null")
	private ProductModel product;
	
	@NonNull
	@NotNull (message = "Avaliable Quantity cannot be null")
	private Integer availableQuantity;

	public StockModel(StoreModel store, ProductModel product, Integer availableQuantity) {
		super();
		this.store = store;
		this.product = product;
		this.availableQuantity = availableQuantity;
		this.storePKModel.setProductId(product.getId());
		this.storePKModel.setStoreId(store.getId());
	}
}
