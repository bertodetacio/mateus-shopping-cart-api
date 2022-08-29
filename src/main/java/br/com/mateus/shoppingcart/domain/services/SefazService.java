package br.com.mateus.shoppingcart.domain.services;

import java.time.Instant;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.DuplicatedDanfeException;
import br.com.mateus.shoppingcart.domain.exceptions.OrderNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Danfe;
import br.com.mateus.shoppingcart.domain.model.Item;
import br.com.mateus.shoppingcart.domain.model.Nfce;
import br.com.mateus.shoppingcart.domain.model.Order;
import br.com.mateus.shoppingcart.domain.repositories.CustomerRepository;
import br.com.mateus.shoppingcart.domain.repositories.DanfeRepository;
import br.com.mateus.shoppingcart.domain.repositories.ItemRepository;
import br.com.mateus.shoppingcart.domain.repositories.NfceRepository;
import br.com.mateus.shoppingcart.domain.repositories.OrderRepository;
@Service
public class SefazService {
	
	@Autowired
	private NfceRepository nfceRepository;	
	
	@Autowired
	private DanfeRepository danfeRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Transactional
	public Danfe genereteDanfe(Long orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow(() ->new OrderNotFoundException(orderId));
		if(order.getDanfe()!=null) {
			throw new DuplicatedDanfeException(order.getId());
		}
		Nfce nfce = generateNfce(order);
		Danfe danfe = generateDanfe(order, nfce);
		return danfe;
	}
	
	private Nfce generateNfce(Order order) {
		Nfce nfce = new Nfce();
		nfce.setIssueTimestamp(Instant.now());
		nfce.setArrivalDepartureTimestamp(Instant.now());
		nfce.setModel(65L);
		nfce.setTotalInvoiceAmount(order.calculateTotalOrderAmount());
		nfce.setOrder(order);
		nfce.setCustomer(order.getCustomer());
		Nfce nfcePersisted = nfceRepository.save(nfce);
		order.setNfce(nfcePersisted);
		order.getCustomer().getNfcesSet().add(nfcePersisted);
		orderRepository.save(order);
		customerRepository.save(order.getCustomer());
		return nfceRepository.findById(nfcePersisted.getId()).get();
	}
	
	private Danfe generateDanfe(Order order, Nfce nfce) {
		Danfe danfe = new Danfe();
		danfe.setOrder(order);
		danfe.setNfce(nfce);
		danfe.setOrder(order);
		danfe.setCustomer(order.getCustomer());
		danfe.getItemsSet().addAll(order.getItemsSet());
		for (Item item: order.getItemsSet()) {
			item.setDanfe(danfe);
		}
		itemRepository.saveAll(order.getItemsSet());
		Danfe danfePersisted = danfeRepository.save(danfe);
		order.setDanfe(danfePersisted);
		danfePersisted.setCustomer(order.getCustomer());
		order.getCustomer().getDanfesSet().add(danfePersisted);
		order.setDanfe(danfePersisted);
		orderRepository.save(order);
		customerRepository.save(order.getCustomer());
		return danfePersisted;
	}
	
	
}
