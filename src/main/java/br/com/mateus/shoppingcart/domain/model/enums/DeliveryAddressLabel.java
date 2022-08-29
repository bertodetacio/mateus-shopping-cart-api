package br.com.mateus.shoppingcart.domain.model.enums;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public enum DeliveryAddressLabel {
	
    HOME(1), WORKPLACE(2), OTHER(3);
	
	@NonNull
	@Positive
	@NotNull(message = "Code cannot be null")
    private Integer code;
	
	public static DeliveryAddressLabel valueOf(int code) {
		for (DeliveryAddressLabel value : DeliveryAddressLabel.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid DeliveryAdressLabel code");
	}
   
}