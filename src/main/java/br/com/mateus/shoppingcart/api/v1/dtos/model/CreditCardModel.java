package br.com.mateus.shoppingcart.api.v1.dtos.model;

import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode (callSuper = true)
@Relation(collectionRelation = "creditCards")
public class CreditCardModel extends CardModel {
	
	private static final long serialVersionUID = 1L;
	
	

	
}
