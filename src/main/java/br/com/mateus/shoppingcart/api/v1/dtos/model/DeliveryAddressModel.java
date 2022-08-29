package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.server.core.Relation;

import br.com.mateus.shoppingcart.api.v1.dtos.model.enums.DeliveryAddressLabelModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "deliveryAddresses")
public class DeliveryAddressModel extends AddressModel {
	
	private static final long serialVersionUID = 1L;
	
	private DeliveryAddressLabelModel deliveryAddressLabel;

	private String otherDeliveryAddressLabel;

	@NotNull(message = "Costumer cannot be null")
	private CustomerModel customer;
	
	private final Set<OrderModel> ordersSet = new HashSet<OrderModel>();
	

}
