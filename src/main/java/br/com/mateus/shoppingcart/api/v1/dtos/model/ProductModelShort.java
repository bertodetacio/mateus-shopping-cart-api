package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.EAN;
import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@EqualsAndHashCode (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "products")
public class ProductModelShort extends BaseModel  {
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@NotNull(message = "Description cannot be null or blank")
	private String name;

	@NotNull(message = "Description cannot be null or blank")
	@NonNull
	private String shortDescription;

	@NotNull(message = "Description cannot be null or blank")
	private String longDescription;

	@NotNull(message = "Branding cannot to be null")
	@NonNull
	private BrandingModelShort branding;

	@EqualsAndHashCode.Include
	@NonNull
	@NotNull(message = "EAN cannot be null or blank")
	@EAN(message = "Invalid EAN")
	private String ean;

	@EqualsAndHashCode.Include
	@NotNull(message = "SKU cannot be null")
	@NonNull
	@Positive
	private Long sku;

	@NotNull(message = "Unit cannot be null or blank")
	private String unit;

	@NotNull
	@Positive(message = "Unit Regular Price must be positive")
	@NotNull(message = "Unit Regular Price cannot be null")
	private BigDecimal unitRegularPrice = new BigDecimal(0.00);

	@NonNull
	@Positive(message = "Unit Sales Price must be positive")
	@NotNull(message = "Unit Sale Price cannot be null")
	private BigDecimal unitSalePrice = new BigDecimal(0.00);
		
}
