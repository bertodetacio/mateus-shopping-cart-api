package br.com.mateus.shoppingcart.domain.model.enums;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DeliveryMethodSupportedByStore {

	DELIVERY(1),PICKUP_STORE(2), DELIVERY_AND_PICKUP (3);

	@NonNull
	@Positive
	@NotNull(message = "Code cannot be null")
	private Integer code;
	
	public static DeliveryMethodSupportedByStore valueOf(int code) {
		for (DeliveryMethodSupportedByStore  value: DeliveryMethodSupportedByStore .values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid ProductShortageCaseAction code");
	}

}