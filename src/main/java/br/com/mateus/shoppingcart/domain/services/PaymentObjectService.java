package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.PaymentObjectNotFoundException;
import br.com.mateus.shoppingcart.domain.model.PaymentObject;
import br.com.mateus.shoppingcart.domain.repositories.PaymentObjectRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PaymentObjectService {
		
	@Autowired
	private PaymentObjectRepository paymentObjectRepository;
	
	public  List<PaymentObject> findAllsPaymentObjects(){
		return paymentObjectRepository.findAll();
	}
	
	public PaymentObject findPaymentObjectByIdOrFail(Long paymentObjectId) {
		return paymentObjectRepository.findById(paymentObjectId).orElseThrow(() -> new PaymentObjectNotFoundException(paymentObjectId));
	}
	

}
