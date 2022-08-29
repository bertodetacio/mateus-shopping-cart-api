package br.com.mateus.shoppingcart.api.v1.dtos.model;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;

import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "foodCards")
public class FoodCardModel extends CardModel {

	private static final long serialVersionUID = 1L;

	@Pattern(regexp = "^[0-9]{3,4}$", message = "Invalid card expiration time")
	@Column(name = "cvv", nullable = true, length = 4)
	private String cvv;

}
