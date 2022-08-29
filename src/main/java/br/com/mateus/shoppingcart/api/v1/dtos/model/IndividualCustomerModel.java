package br.com.mateus.shoppingcart.api.v1.dtos.model;

import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode (callSuper = true)
@Relation(collectionRelation = "individualCustomers")
public class IndividualCustomerModel extends CustomerModel {
	
	private static final long serialVersionUID = 1L;
	


}
