package br.com.mateus.shoppingcart.domain.model.enums;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PaymentMethod {

	CREDIT_CARD_ONLY(1), CREDIT_CARD_AND_DIGITAL_ACCOUNT(2), FOOD_CARD_ONLY(3), FOOD_CARD_AND_DIGITAL_ACCOUNT(4), DIGITAL_ACCOUNT_ONLY(5), PIX_ONLY(6), PIX_AND_DIGITAL_ACCOUNT(7);

	@NonNull
	@Positive
	@NotNull(message = "Code cannot be null")
	private Integer code;
	
	public static PaymentMethod valueOf(int code) {
		for (PaymentMethod value: PaymentMethod.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid PaymentMethod code");
	}

}