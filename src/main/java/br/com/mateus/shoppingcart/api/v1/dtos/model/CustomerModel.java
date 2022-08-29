package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@EqualsAndHashCode (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "customers")
public class CustomerModel extends UserModel {
	
	private static final long serialVersionUID = 1L;
	
 	@JsonIgnore
	@NonNull
	@NotNull(message = "Contract cannot be null")
	private ContractModel contract;
	
 	@JsonIgnore
	private final Set<DeliveryAddressModel> deliveriesAddressesSet = new HashSet<DeliveryAddressModel>();
	
 	@JsonIgnore
	private final Set<PaymentObjectModel> paymentMethodsSet = new HashSet<PaymentObjectModel>();
	
 	@JsonIgnore
	private final Set<CartModel> cartsSet= new HashSet<CartModel>();
	
 	@JsonIgnore
	private final Set<OrderModel> ordersSet= new HashSet<OrderModel>();
	
 	@JsonIgnore
	private DigitalAccountModel digitalAccountModel;
	


}
