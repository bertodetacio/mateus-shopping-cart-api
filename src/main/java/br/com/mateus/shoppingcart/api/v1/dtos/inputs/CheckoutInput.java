package br.com.mateus.shoppingcart.api.v1.dtos.inputs;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutInput  {


	@NotNull
	@NotNull
	ShippingMethodChoseByCustomerInput shippingMethodChoseByCustomer;

	@NotNull
	@NotNull
	private DeliveryAddressInput deliveryAddress;

	
	@NotNull
	@NotNull
	private PaymentMethodInput paymentMethod;

	@NotNull
	@NotNull
	private PaymentObjectInput paymentObject;

	@NotNull
	@NotNull
	private DigitalAccountInput digitalAccount;

	
	@NotNull
	@NotNull
	private ProductShortCaseActionInput productShortCaseAction;

}
