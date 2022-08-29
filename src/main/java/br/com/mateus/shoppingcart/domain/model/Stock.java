package br.com.mateus.shoppingcart.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.mateus.shoppingcart.domain.model.pk.StoreProductPK;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Data
@EqualsAndHashCode (callSuper = false, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "stocks")
public class Stock  {
	
	@EqualsAndHashCode.Include
	@EmbeddedId
	private final StoreProductPK storePK = new StoreProductPK();

	@EqualsAndHashCode.Include
	@NonNull
	@NotNull (message = "Customer cannot be null")
	@ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@MapsId ("storeId")
	@JoinColumn(name = "store_id")
	private Store store;
	
	@EqualsAndHashCode.Include
	@NonNull
	@NotNull (message = "Store cannot be null")
	@ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@MapsId ("productId")
	@JoinColumn(name = "product_id")
	private Product product;
	
	@NonNull
	@NotNull (message = "Avaliable Quantity cannot be null")
	private Integer availableQuantity;

	public Stock(Store store, Product product, Integer availableQuantity) {
		super();
		this.store = store;
		this.product = product;
		this.availableQuantity = availableQuantity;
		this.storePK.setProductId(product.getId());
		this.storePK.setStoreId(store.getId());
	}
	
}
