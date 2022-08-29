package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.PaymentObjectController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.PaymentObjectModelShort;
import br.com.mateus.shoppingcart.domain.model.PaymentObject;

@Component
public class PaymentObjectModelShortAssembler extends RepresentationModelAssemblerSupport<PaymentObject, PaymentObjectModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public PaymentObjectModelShortAssembler() {
		super(PaymentObjectController.class, PaymentObjectModelShort.class);
	}

	@Override
	public PaymentObjectModelShort toModel(PaymentObject paymentObject) {
		PaymentObjectModelShort paymentObjectModel = null;
		paymentObjectModel = createModelWithId(paymentObject.getId(), paymentObject);
		modelMapper.map(paymentObject, paymentObjectModel);
		return paymentObjectModel;
	}
	
	

}
