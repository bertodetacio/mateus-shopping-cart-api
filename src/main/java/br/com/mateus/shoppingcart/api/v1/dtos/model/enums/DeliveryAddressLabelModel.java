package br.com.mateus.shoppingcart.api.v1.dtos.model.enums;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public enum DeliveryAddressLabelModel implements Serializable {
	
    HOME(1), WORKPLACE(2), OTHER(3);
	
	@NonNull
	@Positive
	@NotNull(message = "Code cannot be null")
    private Integer code;
	
	public static DeliveryAddressLabelModel valueOf(int code) {
		for (DeliveryAddressLabelModel value : DeliveryAddressLabelModel.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid DeliveryAdressLabel code");
	}
   
}