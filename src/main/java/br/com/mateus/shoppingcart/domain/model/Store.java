package br.com.mateus.shoppingcart.domain.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.mateus.shoppingcart.domain.model.enums.DeliveryMethodSupportedByStore;
import br.com.mateus.shoppingcart.domain.model.enums.ShippingMethodChosenByCustomer;
import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stores")
@PrimaryKeyJoinColumn(name = "store_id")
public class Store extends Company {
	
	@Default
	@NotNull (message = "Shipment Way cannot be null")
	@Column(name = "shipment_way", nullable = false)
	private DeliveryMethodSupportedByStore deliveryMethodSupportedByStore = DeliveryMethodSupportedByStore.DELIVERY_AND_PICKUP;
	
	@Default
	@Column(name = "maximum_delivery_distance_in_Km", nullable = true)
	private Double maximumDeliveryDistanceInKm = 0.0;
	
	@Default
	@NotNull (message = "Shipment Way cannot be null")
	@Column(name = "kilometer_price", nullable = true, precision = 10)
	private BigDecimal kilometerPrice = new BigDecimal (0.00);
	
	@Default
	@Column(name = "custom_fixed_shipping", nullable = true, precision = 10)
	private BigDecimal customFixedShipping = new BigDecimal (0.00);

	@NotNull (message = "Category cannot be null")
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "stores_departments", joinColumns = @JoinColumn(name = "store_id"), inverseJoinColumns = @JoinColumn(name = "department_id"))
	private final Set<Department> departmentsSet = new HashSet<Department>();
	
	@OneToMany(mappedBy = "store")
    private final Set<Stock> socksSet= new HashSet<Stock>();
	
	@OneToMany(mappedBy = "store")
    private final Set<Cart> cartsSet= new HashSet<Cart>();
	
	@OneToMany(mappedBy = "store")
    private final Set<Order> ordersSet= new HashSet<Order>();
	
	public boolean isSuperted(ShippingMethodChosenByCustomer shippingMethodChosenByCustomer) {
		if(shippingMethodChosenByCustomer == ShippingMethodChosenByCustomer.DELIVERY && (this.deliveryMethodSupportedByStore==DeliveryMethodSupportedByStore.DELIVERY || this.deliveryMethodSupportedByStore == DeliveryMethodSupportedByStore.DELIVERY_AND_PICKUP)) {
			return true;
		}
		else if(shippingMethodChosenByCustomer == ShippingMethodChosenByCustomer.PICKUP_STORE && (this.deliveryMethodSupportedByStore==DeliveryMethodSupportedByStore.PICKUP_STORE|| this.deliveryMethodSupportedByStore == DeliveryMethodSupportedByStore.DELIVERY_AND_PICKUP)) {
			return true;
		}
		else {
			return false;
		}
	}


}
