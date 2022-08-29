package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

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
@Relation(collectionRelation = "items")
public class ItemModelShort extends BaseModelShort {
	
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@NotNull(message = "Quantity cannot be null")
	private Integer quantity = 0;

	@NonNull
	@NotNull(message = "Price cannot be null")
	private BigDecimal price = new BigDecimal(0.00);

	@NonNull
	@NotNull(message = "Product cannot be null")
	private ProductModelShort product;
	
}
