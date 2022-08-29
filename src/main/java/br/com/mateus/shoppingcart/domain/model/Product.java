package br.com.mateus.shoppingcart.domain.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.EAN;
import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

	@EqualsAndHashCode.Include
	@NotNull(message = "Description cannot be null or blank")
	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@NotNull(message = "Description cannot be null or blank")
	@NonNull
	@Column(name = "short_description", nullable = false, length = 250)
	private String shortDescription;

	@NotNull(message = "Description cannot be null or blank")
	@Column(name = "long_description", nullable = false)
	private String longDescription;

	@NotNull(message = "Branding cannot to be null")
	@NonNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "state_id", nullable = false)
	private Branding branding;

	@EqualsAndHashCode.Include
	@NonNull
	@NotNull(message = "EAN cannot be null or blank")
	@EAN(message = "Invalid EAN")
	@Column(name = "ean", nullable = false, unique = true)
	private String ean;

	@EqualsAndHashCode.Include
	@NotNull(message = "SKU cannot be null")
	@NonNull
	@Positive
	@Column(name = "sku", nullable = false, unique = true)
	private Long sku;

	@NotNull(message = "Unit cannot be null or blank")
	@Column(name = "unit", nullable = false, length = 100, precision = 10)
	private String unit;

	@Default
	@NotNull
	@Positive(message = "Unit Regular Price must be positive")
	@NotNull(message = "Unit Regular Price cannot be null")
	@Column(name = "unit_regular_price", nullable = false, precision = 10)
	private BigDecimal unitRegularPrice = new BigDecimal(0.00);

	@Default
	@NonNull
	@Positive(message = "Unit Sales Price must be positive")
	@NotNull(message = "Unit Sale Price cannot be null")
	@Column(name = "unit_sale_price", nullable = false, precision = 10)
	private BigDecimal unitSalePrice = new BigDecimal(0.00);
	
	@Default
	@Positive(message = "Cashback Percentage must be positive")
	@Column(name = "cashback_percentage", nullable = true)
	private BigDecimal cashbackPercentage = new BigDecimal(0);

	@Default
	@NonNull
	@NotNull
	@Positive(message = "Minimum Order Quantity must be positive")
	@Column(name = "minimum_order_quantity", nullable = false)
	private Integer minimumOrderQuantity = 0;

	@NonNull
	@NotBlank(message = "Image URL cannot be null or blank")
	@URL(message = "Invalid URL")
	@Column(name = "image_url", nullable = false)
	private String imageUrl;

	@NotNull(message = "Sections cannot be null")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "productsSet")
	private final Set<Section> sectionsSet = new HashSet<>();

	@OneToMany(mappedBy = "product")
	private final Set<Stock> stocksSet = new HashSet<Stock>();
	
	@NotNull(message = "Items Set Set cannot be null")
	@OneToMany(mappedBy ="product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private final Set <Item> itemsSet = new HashSet<Item> ();
	
	public BigDecimal getSalePrice() {
		if (unitSalePrice.compareTo(unitRegularPrice) < -1) {
			return unitSalePrice;
		} else {
			return unitRegularPrice;
		}
	}
	
	public BigDecimal getDiscountAmountPerUnit() {
		BigDecimal discount = new BigDecimal(0.00);
		if(unitSalePrice.compareTo(unitRegularPrice) < -1){
			discount = unitRegularPrice.subtract(unitSalePrice);
		}
		return discount;
	}

}
