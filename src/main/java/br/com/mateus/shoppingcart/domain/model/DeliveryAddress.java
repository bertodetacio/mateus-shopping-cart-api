package br.com.mateus.shoppingcart.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.mateus.shoppingcart.domain.model.enums.DeliveryAddressLabel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deliveries_addresses")
@PrimaryKeyJoinColumn(name = "delivery_address_id")
public class DeliveryAddress extends Address {

	private DeliveryAddressLabel deliveryAddressLabel;

	@Column(name = "other_delivery_address_label", nullable = true)
	private String otherDeliveryAddressLabel;

	@NotNull(message = "Costumer cannot be null")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany (mappedBy = "deliveryAddress")
	private final Set<Order> ordersSet = new HashSet<Order>();

}
