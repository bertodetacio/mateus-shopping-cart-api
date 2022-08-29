package br.com.mateus.shoppingcart.domain.model.enums;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProductShortageCaseAction {

	RECEIVE_A_CALL(1), AUTHORIZE_SUBSTITUTION(2), CONTINUE_WITHOUT(3);
	
	@NonNull
	@Positive
	@NotNull(message = "Code cannot be null")
	private Integer code;
	
	public static ProductShortageCaseAction valueOf(int code) {
		for (ProductShortageCaseAction value: ProductShortageCaseAction.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid ProductShortageCaseAction code");
	}

}