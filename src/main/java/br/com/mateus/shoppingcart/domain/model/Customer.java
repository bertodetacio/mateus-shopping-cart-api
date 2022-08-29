package br.com.mateus.shoppingcart.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@ToString (callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "customers")
@PrimaryKeyJoinColumn(name = "customers_id")
public abstract class Customer extends User {
	
	private static final long serialVersionUID = 1L;

	@NotNull(message = "Contract cannot be null")
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "contract_id")
	private Contract contract;
	
	@OneToMany(mappedBy ="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private final Set<DeliveryAddress> deliveriesAddressesSet = new HashSet<DeliveryAddress>();
	
	@OneToMany(mappedBy ="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private final Set<PaymentObject> paymentMethodsSet = new HashSet<PaymentObject>();
	
	@OneToMany(mappedBy = "customer")
    private final Set<Cart> cartsSet= new HashSet<Cart>();
	
	@OneToMany(mappedBy = "customer")
    private final Set<Order> ordersSet= new HashSet<Order>();
	
	@OneToMany(mappedBy ="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private final Set<Danfe> danfesSet = new HashSet<Danfe>();
	
	@OneToMany(mappedBy ="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private final Set<Nfce> nfcesSet = new HashSet<Nfce>();
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "digital_account_id", nullable = true)
	private DigitalAccount digitalAccount;
	
	
	
}


