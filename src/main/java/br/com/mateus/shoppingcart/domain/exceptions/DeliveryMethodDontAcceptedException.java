package br.com.mateus.shoppingcart.domain.exceptions;

import lombok.NoArgsConstructor;
import lombok.experimental.StandardException;

@NoArgsConstructor
@StandardException
public class DeliveryMethodDontAcceptedException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public DeliveryMethodDontAcceptedException(Long storeId, Integer shipmentWayId) {
		super("The store Id " + storeId+ " connot acceptet the shipment way "+shipmentWayId);
	}

}
