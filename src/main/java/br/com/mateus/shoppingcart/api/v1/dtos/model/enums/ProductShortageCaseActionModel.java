package br.com.mateus.shoppingcart.api.v1.dtos.model.enums;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProductShortageCaseActionModel implements Serializable{

	RECEIVE_A_CALL(1), AUTHORIZE_SUBSTITUTION(2), CONTINUE_WITHOUT(3);
	
	@NonNull
	@Positive
	@NotNull(message = "Code cannot be null")
	private Integer code;
	
	public static ProductShortageCaseActionModel valueOf(int code) {
		for (ProductShortageCaseActionModel value: ProductShortageCaseActionModel.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid ProductShortageCaseAction code");
	}

}