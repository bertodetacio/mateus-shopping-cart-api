package br.com.mateus.shoppingcart.api.v1.dtos.model.enums;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ShippingMethodChosenByCustomerModel {

	DELIVERY(1),PICKUP_STORE(2);

	@NonNull
	@Positive
	@NotNull(message = "Code cannot be null")
	private Integer code;
	
	public static ShippingMethodChosenByCustomerModel valueOf(int code) {
		for (ShippingMethodChosenByCustomerModel  value: ShippingMethodChosenByCustomerModel .values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid ProductShortageCaseAction code");
	}

}