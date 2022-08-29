package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.server.core.Relation;

import br.com.mateus.shoppingcart.api.v1.dtos.model.enums.DeliveryMethodSupportedByStoreModel;
import br.com.mateus.shoppingcart.domain.model.Cart;
import br.com.mateus.shoppingcart.domain.model.Category;
import br.com.mateus.shoppingcart.domain.model.Department;
import br.com.mateus.shoppingcart.domain.model.Order;
import br.com.mateus.shoppingcart.domain.model.Stock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "stores")
public class StoreModel extends CompanyModel {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Delivery Method Supported By Store be null")
	private DeliveryMethodSupportedByStoreModel deliveryMethodSupportedByStoreModel;

	@Column(name = "maximum_delivery_distance_in_Km", nullable = true)
	private Double maximumDeliveryDistanceInKm = 0.0;

	@NotNull(message = "Kilometer Pricecannot be null")
	private BigDecimal kilometerPrice = new BigDecimal(0.00);

	private BigDecimal customFixedShipping = new BigDecimal(0.00);

	@NotNull(message = "Category cannot be null")
	private Category category;

	private final Set<Department> departmentsSet = new HashSet<Department>();

	private final Set<Stock> socksSet = new HashSet<Stock>();

	private final Set<Cart> cartsSet = new HashSet<Cart>();

	private final Set<Order> ordersSet = new HashSet<Order>();

}
