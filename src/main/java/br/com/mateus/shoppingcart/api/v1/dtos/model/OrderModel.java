package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.springframework.hateoas.server.core.Relation;

import br.com.mateus.shoppingcart.api.v1.dtos.model.enums.DeliveryMethodSupportedByStoreModel;
import br.com.mateus.shoppingcart.api.v1.dtos.model.enums.ProductShortageCaseActionModel;
import br.com.mateus.shoppingcart.domain.model.enums.DeliveryMethodSupportedByStore;
import br.com.mateus.shoppingcart.domain.model.enums.OrderStatus;
import br.com.mateus.shoppingcart.domain.model.enums.PaymentMethod;
import br.com.mateus.shoppingcart.domain.model.enums.ShippingMethodChosenByCustomer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@EqualsAndHashCode (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "orders")
public class OrderModel extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private BigDecimal amountPaidByCreditCard = new BigDecimal(0.00);

	@NotNull
	private BigDecimal amountPaidByFoodCard = new BigDecimal(0.00);

	@NotNull
	private BigDecimal amountPaidByPix = new BigDecimal(0.00);
	
	@NotNull
	private BigDecimal amountPaidByDigitalAccount = new BigDecimal(0.00);

	@NonNull
	@NotNull(message = "Fixing Shipping cannot be null")
	private BigDecimal fixedShipping = new BigDecimal(0.00);

	@NonNull
	@NotNull(message = "Order cannot be null")
	private Integer installmentsNumber = 1;

	private Instant generetedTimestamp;
	
	private Instant underReviewTimestamp;

	private Instant rejectedPaymentTimestamp;
	
	private Instant authorizedPaymentTimestamp;
	
	private Instant separationTimestamp;
	
	private Instant readyForDeliveryTimestamp;
	
	private Instant readyForPickupTimestamp;

	private Instant wentOutForDeliveryTimestamp;

	private Instant deliveredTimestamp;

	private Instant canceledTimestamp;
	
	@NonNull
	@NotNull(message = "Order Status cannot be null")
	private OrderStatus orderStatus;

	@NonNull
	@NotNull(message = "Shipping Method Chosen By Customer cannot be null")
	private ShippingMethodChosenByCustomer shippingMethodChosenByCustomer = ShippingMethodChosenByCustomer.DELIVERY;

	@NonNull
	@NotNull(message = "Payment method cannot be null")
	private PaymentMethod paymentMethod = PaymentMethod.PIX_ONLY;
	
	@Pattern (regexp = "^[0-9a-fA-F]{8}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{12}$")
	private String pixKey;

	@NonNull
	@NotNull(message = "Store cannot be null")
	private StoreModel store;

	@NonNull
	@NotNull(message = "Customer cannot be null")
	private CustomerModel customer;

	private PaymentObjectModel paymentObject;
	
	private DanfeModel danfe;

	private DeliveryAddressModel deliveryAddress;
	
	@NonNull
	@NotNull(message = "Product Shortage Case Action cannot be null")
	private ProductShortageCaseActionModel productShortageCaseAction;
	
	@Positive
	private Integer itemQuantity;
	
	@NonNull
	@NotNull (message = "Product quantity cannot be null")
	@Positive
	private Integer productsQuantity;
	
	@NotNull
	private BigDecimal subtotal = new BigDecimal (0.00);
	
	@NotNull
	private BigDecimal totalOrderAmount = new BigDecimal(0.00);
	
	@NotNull
	private BigDecimal cashBackAmount = new BigDecimal(0.00);
	
	@NotNull
	private BigDecimal totalDiscountAmount = new BigDecimal(0.00);
	
	private Set<ItemModel> itemsSet;;

	
}
