package br.com.mateus.shoppingcart.domain.utils;

import java.time.Instant;
import java.util.TimerTask;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import br.com.mateus.shoppingcart.domain.model.Cart;
import br.com.mateus.shoppingcart.domain.model.Order;
import br.com.mateus.shoppingcart.domain.model.enums.CartStatus;
import br.com.mateus.shoppingcart.domain.model.enums.OrderStatus;
import br.com.mateus.shoppingcart.domain.model.enums.ShippingMethodChosenByCustomer;
import br.com.mateus.shoppingcart.domain.repositories.CartRepository;
import br.com.mateus.shoppingcart.domain.repositories.OrderRepository;
import br.com.mateus.shoppingcart.domain.repositories.StockRepository;
import br.com.mateus.shoppingcart.domain.services.BankService;
import br.com.mateus.shoppingcart.domain.services.SefazService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateOrderStatusTimerTask extends TimerTask {

	@NotNull
	@NonNull
	private Long orderId;
	
	@NotNull
	@NonNull
	private Long cartId;

	@NotNull
	@NonNull
	private OrderRepository orderRepository;
	
	@NotNull
	@NonNull
	private StockRepository stockRepository;
	
	@NotNull
	@NonNull
	private CartRepository cartRepository;
	
	@NotNull
	@NonNull
	private SefazService sefazService;
	
	@NotNull
	@NonNull
	private BankService bankService;
	
	@Override
	public void run() {
		updateOrderStatus();
	}

	@Transactional
	private void updateOrderStatus() {
		try {
			Order order = orderRepository.findById(orderId).get();
			OrderStatus orderStatus = order.getOrderStatus();
			ShippingMethodChosenByCustomer shippingMethodChosenByCustomer = order.getShippingMethodChosenByCustomer();
		switch (orderStatus) {
			case CREATED_ORDER: {
				order.setOrderStatus(OrderStatus.ORDER_UNDER_REVIEW);
				order.setUnderReviewTimestamp(Instant.now());
				break;
			}
			case ORDER_UNDER_REVIEW: {
				order.setOrderStatus(OrderStatus.AUTHORIZED_ORDER_PAYMENT);
				order.setAuthorizedPaymentTimestamp(Instant.now());
				break;
			}
			case AUTHORIZED_ORDER_PAYMENT: {
				order.setOrderStatus(OrderStatus.ORDER_IN_SEPARATION);
				order.setSeparationTimestamp(Instant.now());
				sefazService.genereteDanfe(order.getId());
				break;
			}
			case ORDER_IN_SEPARATION: {
				if (shippingMethodChosenByCustomer == ShippingMethodChosenByCustomer.PICKUP_STORE) {
					order.setOrderStatus(OrderStatus.ORDER_READY_FOR_PICKUP);
					order.setReadyForPickupTimestamp(Instant.now());
				}
				if (shippingMethodChosenByCustomer == ShippingMethodChosenByCustomer.DELIVERY) {
					order.setOrderStatus(OrderStatus.ORDER_READY_FOR_DELIVERY);
					order.setReadyForDeliveryTimestamp(Instant.now());
				}
				break;
			}
			case ORDER_READY_FOR_PICKUP: {
				order.setOrderStatus(OrderStatus.ORDER_DELIVERED);
				order.setDeliveredTimestamp(Instant.now());
				break;
			}
			case ORDER_READY_FOR_DELIVERY: {
				order.setOrderStatus(OrderStatus.ORDER_WENT_OUT_FOR_DELIVERY);
				order.setWentOutForDeliveryTimestamp(Instant.now());
				break;
			}
			case ORDER_WENT_OUT_FOR_DELIVERY: {
				order.setOrderStatus(OrderStatus.ORDER_DELIVERED);
				order.setDeliveredTimestamp(Instant.now());
				break;
			}
			case ORDER_DELIVERED: {
				cancel();
				break;
			}
			case ORDER_CANCELED: {
				Cart cart = cartRepository.findById(cartId).get();
				cart.setCartStatus(CartStatus.OPEN);
				cartRepository.save(cart);
				bankService.reverseAmountToDigitalAccount(cart.getCustomer().getId(), order.getAmountPaidByDigitalAccount());
				cancel();
				break;
			}
			case REJECTED_ORDER_PAYMENT: {
				Cart cart = cartRepository.findById(cartId).get();
				cart.setCartStatus(CartStatus.OPEN);
				cartRepository.save(cart);
				bankService.reverseAmountToDigitalAccount(cart.getCustomer().getId(), order.getAmountPaidByDigitalAccount());
				cancel();
				break;
			}
			default:
				cancel();
			}
			orderRepository.save(order);
		} catch (Exception e) {
			cancel();
			e.printStackTrace();
		}

	}
	

}
