package br.com.mateus.shoppingcart.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import br.com.mateus.shoppingcart.domain.model.enums.OrderStatus;
import br.com.mateus.shoppingcart.domain.model.enums.PaymentMethod;
import br.com.mateus.shoppingcart.domain.model.enums.ProductShortageCaseAction;
import br.com.mateus.shoppingcart.domain.model.enums.ShippingMethodChosenByCustomer;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	@Default
	@Column(name = "amount_paid_by_credit_card", nullable = true)
	private BigDecimal amountPaidByCreditCard = new BigDecimal(0.00);

	@Default
	@Column(name = "amount_paid_by_food_card", nullable = true)
	private BigDecimal amountPaidByFoodCard = new BigDecimal(0.00);

	@Default
	@Column(name = "amount_paid_by_pix", nullable = true)
	private BigDecimal amountPaidByPix = new BigDecimal(0.00);
	
	@Default
	@Column(name = "amount_paid_by_digital_account", nullable = true)
	private BigDecimal amountPaidByDigitalAccount = new BigDecimal(0.00);

	@Default
	@NonNull
	@NotNull(message = "Fixing Shipping cannot be null")
	@Column(name = "fixed_shipping", nullable = false, precision = 10)
	private BigDecimal fixedShipping = new BigDecimal(0.00);

	@Default
	@NotNull(message = "Order cannot be null")
	@Column(name = "installments_number", nullable = true)
	private Integer installmentsNumber = 1;

	@Column(name = "genereted_timestamp", nullable = true)
	private Instant generetedTimestamp;
	
	@Column(name = "under_review_timestamp", nullable = true)
	private Instant underReviewTimestamp;

	@Column(name = "rejected_payment_timestamp", nullable = true)
	private Instant rejectedPaymentTimestamp;
	
	@Column(name = "authorized_payment_timestamp", nullable = true)
	private Instant authorizedPaymentTimestamp;
	
	@Column(name = "separation_timestamp", nullable = true)
	private Instant separationTimestamp;
	
	@Column(name = "ready_for_delivery_timestamp", nullable = true)
	private Instant readyForDeliveryTimestamp;
	
	@Column(name = "ready_for_pickup_timestamp", nullable = true)
	private Instant readyForPickupTimestamp;

	@Column(name = "went_out_for_delivery_timestamp", nullable = true)
	private Instant wentOutForDeliveryTimestamp;

	@Column(name = "delivered_timestamp", nullable = true)
	private Instant deliveredTimestamp;

	@Column(name = "cancelled_timestamp", nullable = true)
	private Instant canceledTimestamp;
	
	@NonNull
	@NotNull(message = "Order Status cannot be null")
	@Enumerated (EnumType.STRING)
	@Column(name = "order_status", nullable = false)
	private OrderStatus orderStatus;

	@Default
	@NonNull
	@NotNull(message = "Shipment Way cannot be null")
	@Column(name = "shipping_method_chosen_by_customer", nullable = false)
	private ShippingMethodChosenByCustomer shippingMethodChosenByCustomer = ShippingMethodChosenByCustomer.DELIVERY;

	@Default
	@NonNull
	@NotNull(message = "Payment method cannot be null")
	@Column(name = "payment_method", nullable = false)
	@Enumerated (EnumType.STRING)
	private PaymentMethod paymentMethod = PaymentMethod.PIX_ONLY;
	
	@Pattern (regexp = "^[0-9a-fA-F]{8}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{12}$")
	@Column(name = "pix_key", nullable = true)
	private String pixKey;

	@NonNull
	@NotNull(message = "Store cannot be null")
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;

	@NonNull
	@NotNull(message = "Customer cannot be null")
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "paymentObject_id")
	private PaymentObject paymentObject;
	
	@OneToOne (mappedBy = "order")
	private Danfe danfe;
	
	@OneToOne (mappedBy = "order")
	private Nfce nfce;
	
	@NonNull
	@NotNull(message = "Cart cannot be null")
	@OneToOne
	@JoinColumn (name = "orderId")
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "delivery_adress_id")
	private DeliveryAddress deliveryAddress;
	
	@NonNull
	@NotNull(message = "Product Shortage Case Action cannot be null")
	@Enumerated (EnumType.STRING)
	private ProductShortageCaseAction productShortageCaseAction;
	
	@Positive
	@Column(name = "item_quantity", nullable = false)
	private Integer itemQuantity;
	
	@NotNull
	@Positive
	@Column(name = "products_quantity", nullable = false)
	private Integer productsQuantity;
	
	@NotNull
	@Default
	@Column(name = "subtotal", nullable = false)
	private BigDecimal subtotal = new BigDecimal (0.00);
	
	@NotNull
	@Default
	@Column(name = "total_order_amount", nullable = true)
	private BigDecimal totalOrderAmount = new BigDecimal(0.00);
	
	@Default
	@Column(name = "cashback_amount", nullable = true)
	private BigDecimal cashBackAmount = new BigDecimal(0.00);
	
	@Default
	@Column(name = "total_discount_amount", nullable = true)
	private BigDecimal totalDiscountAmount = new BigDecimal(0.00);
	
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private final Set<Item> itemsSet = new HashSet<Item>();

	public BigDecimal calculateSubTotal() {
		BigDecimal sum = new BigDecimal(0.00);
		for (Item item : itemsSet) {
			sum = sum.add(item.getSubTotal());
		}
		return sum;
	}

	public BigDecimal calculateTotalOrderAmount() {
		return calculateSubTotal().add(fixedShipping).subtract(totalDiscountAmount);
	}

	public BigDecimal calculateTotalAmountPaid() {
		return amountPaidByPix.add(amountPaidByCreditCard).add(amountPaidByFoodCard).add(amountPaidByDigitalAccount).subtract(totalDiscountAmount);
	}
	

	public int calculateProductsQuantity() {
		return itemsSet.size();
	}
	

	public int calculateItemsQuantity() {
		int quantity = 0;
		for (Item item : itemsSet) {
			quantity = quantity + item.getQuantity();
		}
		return quantity;
	}
	
	public BigDecimal calculateCashBackAmmount() {
		BigDecimal sum = new BigDecimal(0.00);
		for (Item item : itemsSet) {
			sum = sum.add(item.getCashBackAmmount());
		}
		return sum;
	}
	
	public BigDecimal calculateTotalDiscountAmount() {
		BigDecimal sum = new BigDecimal(0.00);
		for (Item item : itemsSet) {
			sum = sum.add(item.getDiscountAmountPerItem());
		}
		return sum;
	}
	

}
