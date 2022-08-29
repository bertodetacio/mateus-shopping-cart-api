package br.com.mateus.shoppingcart.api.v1.dtos.model.enums;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CartStatusModel implements Serializable {

	OPEN(1), CLOSE(2);

	@NonNull
	@Positive
	@NotNull(message = "Code cannot be null")
	private Integer code;
	
	public static CartStatusModel valueOf(int code) {
		for (CartStatusModel value : CartStatusModel.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid CartStatus code");
	}
	

}