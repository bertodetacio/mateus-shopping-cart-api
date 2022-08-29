package br.com.mateus.shoppingcart.api.v1.dtos.model;

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
@Relation(collectionRelation = "paymentObjects")
public class PaymentObjectModelShort extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@NotNull (message = "Costumer cannot be null")
	private CustomerModelShort customer;
	
   

}
