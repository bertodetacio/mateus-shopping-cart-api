package br.com.mateus.shoppingcart.api.v1.dtos.model.enums;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OrderStatusModel {

	CREATED_ORDER(1), ORDER_UNDER_REVIEW(2),
	REJECTED_ORDER_PAYMENT(3), AUTHORIZED_ORDER_PAYMENT(4),
	ORDER_IN_SEPARATION(5), ORDER_READY_FOR_PICKUP (6), ORDER_READY_FOR_DELIVERY(7),
	ORDER_WENT_OUT_FOR_DELIVERY(8), ORDER_DELIVERED(9), ORDER_CANCELED (10);

	@NonNull
	@Positive
	@NotNull(message = "Code cannot be null")
	private Integer code;
	
	public static OrderStatusModel valueOf(int code) {
		for (OrderStatusModel value : OrderStatusModel.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
	
}
