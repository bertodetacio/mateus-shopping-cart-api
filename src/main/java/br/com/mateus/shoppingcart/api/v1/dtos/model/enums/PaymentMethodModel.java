package br.com.mateus.shoppingcart.api.v1.dtos.model.enums;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PaymentMethodModel implements Serializable {

	PIX_ONLY(1), PIX_AND_DIGITAL_ACCOUNT(2), CREDIT_CARD_ONLY(3),
	CREDIT_CARD_AND_DIGITAL_ACCOUNT(4), FOOD_CARD_ONLY(5),
	FOOD_CARD_AND_DIGITAL_ACCOUNT(6), DIGITAL_ACCOUNT_ONLY(7);

	@NonNull
	@Positive
	@NotNull(message = "Code cannot be null")
	private Integer code;
	
	public static PaymentMethodModel valueOf(int code) {
		for (PaymentMethodModel value: PaymentMethodModel.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid PaymentMethod code");
	}

}