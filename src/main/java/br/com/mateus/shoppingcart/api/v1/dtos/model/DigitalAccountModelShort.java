package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "digitalAccounts")
public class DigitalAccountModelShort extends BaseModel {
	
	private static final long serialVersionUID = 1L;

	@NotNull
	@PositiveOrZero (message = "Balance must to positive or zero")
	private BigDecimal balance = new BigDecimal(0.00);
	
	@NotNull
	@NotNull (message = "Customer Account cannot be null")
	private CustomerModelShort customer;

	
}
