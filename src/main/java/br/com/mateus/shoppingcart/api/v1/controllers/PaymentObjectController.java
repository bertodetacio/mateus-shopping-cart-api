package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.PaymentObjectControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.PaymentObjectModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.PaymentObjectModelShort;
import br.com.mateus.shoppingcart.domain.model.PaymentObject;
import br.com.mateus.shoppingcart.domain.services.PaymentObjectService;


@RestController
@RequestMapping(path = "api/v1/paymentObjects", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentObjectController implements PaymentObjectControllerOpenApi {
		
	@Autowired
	private PaymentObjectService paymentObjectService;
	
	@Autowired
	private PaymentObjectModelShortAssembler paymentObjectModelAssembler;
	
	
	@Override
	@GetMapping(path = "/{paymentObjectId}")
	public PaymentObjectModelShort findPaymentObjectById(@PathVariable (name = "paymentObjectId", required = true) Long paymentObjectId) {
		PaymentObject paymentObject =  paymentObjectService.findPaymentObjectByIdOrFail(paymentObjectId);
		return paymentObjectModelAssembler.toModel(paymentObject);
	}

	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<PaymentObjectModelShort> findAllPaymentObjects() {
		List <PaymentObject> paymentObjectsList = paymentObjectService.findAllsPaymentObjects();
		return paymentObjectModelAssembler.toCollectionModel(paymentObjectsList);
	}

}
