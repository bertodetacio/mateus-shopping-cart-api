package br.com.mateus.shoppingcart.api.v1.dtos.model;

import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode (callSuper = true)
@NoArgsConstructor
@Relation(collectionRelation = "customers")
public class CustomerModelShort extends UserModelShort{
	
	private static final long serialVersionUID = 1L;


}
