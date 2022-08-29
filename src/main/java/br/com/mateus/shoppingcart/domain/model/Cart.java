package br.com.mateus.shoppingcart.domain.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.mateus.shoppingcart.domain.model.enums.CartStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@RequiredArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode (callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "carts")
@Inheritance (strategy = InheritanceType.JOINED)
public class Cart extends BaseEntity {
	
	@NonNull
	@NotNull(message = "Cart Status cannot be null")
	@Column (name = "cart_status", nullable = false)
	private CartStatus cartStatus;
	
	@EqualsAndHashCode.Include
	@NonNull
	@NotNull(message = "Customer cannot be null")
	@OneToOne
	@JoinColumn (name = "customer_id")
	private Customer customer;
	
	@EqualsAndHashCode.Include
	@NonNull
	@NotNull(message = "Store cannot be null")
	@OneToOne
	@JoinColumn (name = "store_id")
	private Store store;
	
	@OneToOne (mappedBy = "cart")
	private Order order;
	
	@NotNull(message = "Items Set Set cannot be null")
	@OneToMany(mappedBy ="cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private final Set <Item> itemsSet = new HashSet<Item> ();

	public BigDecimal getTotalOfProducts() {
		BigDecimal sum = new BigDecimal(0.00);
		for (Item item : itemsSet) {
			sum = sum.add(item.getSubTotal());
		}
		return sum;
	}

	public BigDecimal getServiceCharge() {
		return store.getCustomFixedShipping();
	}
	
	public BigDecimal getTotalPayable() {
		BigDecimal sum = new BigDecimal(0.00);
		for (Item item : itemsSet) {
			sum = sum.add(item.getSubTotal());
		}
		sum = sum.add(getServiceCharge());
		return sum;
	}

	public boolean isEmpty() {
		return itemsSet.isEmpty();
	}

}
