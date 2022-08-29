package br.com.mateus.shoppingcart.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "items")
public class Item extends BaseEntity {

	@Default
	@NonNull
	@NotNull(message = "Quantity canno be null")
	@Column(name = "quantity", nullable = false)
	private Integer quantity = 0;

	@Default
	@NonNull
	@NotNull(message = "Price cannot be null")
	@Column(name = "price", nullable = false, precision = 10)
	private BigDecimal price = new BigDecimal(0.00);

	@NonNull
	@NotNull(message = "Product cannot be null")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@NonNull
	@NotNull(message = "Cart cannot be null")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = true)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "danfe_id", nullable = true)
	private Danfe danfe;

	public BigDecimal getSubTotal() {
		return price.multiply(new BigDecimal(quantity));
	}

	public BigDecimal getCashBackAmmount() {
		return price.multiply(new BigDecimal(quantity)).multiply(product.getCashbackPercentage()).divide(new BigDecimal(100));
	}
	
	public BigDecimal getDiscountAmountPerItem() {
		BigDecimal discount = new BigDecimal(0.00);
		if(price.compareTo(product.getUnitRegularPrice()) < -1){
			discount = (product.getUnitRegularPrice().subtract(price)).multiply(new BigDecimal(quantity));
		}
		return discount;
	}

}
