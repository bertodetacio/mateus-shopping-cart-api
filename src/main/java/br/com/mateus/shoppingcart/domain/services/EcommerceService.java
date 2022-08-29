package br.com.mateus.shoppingcart.domain.services;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Timer;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.CartCreationProhibitionException;
import br.com.mateus.shoppingcart.domain.exceptions.CartNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.CloseCartException;
import br.com.mateus.shoppingcart.domain.exceptions.CreditCardNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.CustomerNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.DanfeNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.DeliveryAddressNotFoundNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.EmptyCartException;
import br.com.mateus.shoppingcart.domain.exceptions.FoodCardNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.ItemNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.ItemRemovalNotAllowedException;
import br.com.mateus.shoppingcart.domain.exceptions.NfceNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.OrderNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.PaymentObjectNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.ProductNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.ProductShortageCaseActionException;
import br.com.mateus.shoppingcart.domain.exceptions.DeliveryMethodDontAcceptedException;
import br.com.mateus.shoppingcart.domain.exceptions.StockInsufficientQuantityException;
import br.com.mateus.shoppingcart.domain.exceptions.StoreNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Cart;
import br.com.mateus.shoppingcart.domain.model.CreditCard;
import br.com.mateus.shoppingcart.domain.model.Customer;
import br.com.mateus.shoppingcart.domain.model.Danfe;
import br.com.mateus.shoppingcart.domain.model.DeliveryAddress;
import br.com.mateus.shoppingcart.domain.model.FoodCard;
import br.com.mateus.shoppingcart.domain.model.Item;
import br.com.mateus.shoppingcart.domain.model.Nfce;
import br.com.mateus.shoppingcart.domain.model.Order;
import br.com.mateus.shoppingcart.domain.model.PaymentObject;
import br.com.mateus.shoppingcart.domain.model.Product;
import br.com.mateus.shoppingcart.domain.model.Stock;
import br.com.mateus.shoppingcart.domain.model.Store;
import br.com.mateus.shoppingcart.domain.model.enums.CartStatus;
import br.com.mateus.shoppingcart.domain.model.enums.OrderStatus;
import br.com.mateus.shoppingcart.domain.model.enums.PaymentMethod;
import br.com.mateus.shoppingcart.domain.model.enums.ProductShortageCaseAction;
import br.com.mateus.shoppingcart.domain.model.enums.ShippingMethodChosenByCustomer;
import br.com.mateus.shoppingcart.domain.model.enums.DeliveryMethodSupportedByStore;
import br.com.mateus.shoppingcart.domain.repositories.CartRepository;
import br.com.mateus.shoppingcart.domain.repositories.CreditCardRepository;
import br.com.mateus.shoppingcart.domain.repositories.CustomerRepository;
import br.com.mateus.shoppingcart.domain.repositories.DanfeRepository;
import br.com.mateus.shoppingcart.domain.repositories.DeliveryAddressRepository;
import br.com.mateus.shoppingcart.domain.repositories.FoodCardRepository;
import br.com.mateus.shoppingcart.domain.repositories.ItemRepository;
import br.com.mateus.shoppingcart.domain.repositories.NfceRepository;
import br.com.mateus.shoppingcart.domain.repositories.OrderRepository;
import br.com.mateus.shoppingcart.domain.repositories.PaymentObjectRepository;
import br.com.mateus.shoppingcart.domain.repositories.ProductRepository;
import br.com.mateus.shoppingcart.domain.repositories.StockRepository;
import br.com.mateus.shoppingcart.domain.repositories.StoreRepository;
import br.com.mateus.shoppingcart.domain.utils.UpdateOrderStatusTimerTask;

@Service
public class EcommerceService {

	private Timer timer = new Timer();

	private long orderUpdateIntervalInMiliseconds = 5 * 1000;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private DeliveryAddressRepository deliveryAddressRepository;

	@Autowired
	private BankService bankService;

	@Autowired
	private PaymentObjectRepository paymentObjectRepository;

	@Autowired
	private CreditCardRepository creditCardRepository;

	@Autowired
	private FoodCardRepository foodCardRepository;

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private DanfeRepository danfeRepository;

	@Autowired
	private NfceRepository nfceRepository;

	@Autowired
	private SefazService sefazService;


	public List<Danfe> findAllDanfes() {
		return danfeRepository.findAll();
	}
	
	public List<Nfce> findAllNfces() {
		return nfceRepository.findAll();
	}
	
	public Nfce findNfceById(Long nfceId) {
		return nfceRepository.findById(nfceId).orElseThrow(()-> new NfceNotFoundException(nfceId));
	}
	
	public Danfe findDanfeById(Long danfeId) {
		return danfeRepository.findById(danfeId).orElseThrow(()-> new DanfeNotFoundException(danfeId));
	}
	
	public List<Cart> findAllCarts(){
		return cartRepository.findAll();
	}
	
	public Cart findCartByIdOrFail(Long id) {
		Cart cart = cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException(id));
		return cart;
	}
	

	public List<Cart> findCartsByCustomerIdOrFail(@Positive @NotNull Long customerId) {
		Customer customer = findCustomerOrFail(customerId);
		return cartRepository.findByCustomer(customer);
	}
	
	public List<Order> findAllOrders() {
		return orderRepository.findAll();
	}

	public List<Order> findOrdersByCustomerIdOrFail(@Positive @NotNull Long customerId) {
		Customer customer = findCustomerOrFail(customerId);
		return orderRepository.findByCustomer(customer);
	}
	
	

	public List<Danfe> findDanfesByCustomerIdOrFail(@Positive @NotNull Long customerId) {
		Customer customer = findCustomerOrFail(customerId);
		return danfeRepository.findByCustomer(customer);
	}

	public List<Nfce> findNfcesByCustomerIdOrFail(@Positive @NotNull Long customerId) {
		Customer customer = findCustomerOrFail(customerId);
		return nfceRepository.findByCustomer(customer);
	}
	


	public Order findOrderByCartIdOrFail(Long cartId) {
		Cart cart = findCartByIdOrFail(cartId);
		Order order = cart.getOrder();
		if (order == null) {
			throw new OrderNotFoundException("No orders associated with the given cart were found.");
		}
		return order;
	}

	public Order findOrderByIdOrFail(Long orderId) {
		return orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
	}

	public Danfe findDanfeByOrderIdOrFail(Long orderId) {
		Order order = findOrderByIdOrFail(orderId);
		Danfe danfe = danfeRepository.findByOrder(order);
		if (danfe == null) {
			throw new DanfeNotFoundException("No Danfe associated with the informed order was found");
		}
		return danfe;

	}
	
	public Nfce findNfceByOrderIdOrFail(Long orderId) {
		Order order = findOrderByIdOrFail(orderId);
		Nfce nfce = nfceRepository.findByOrder(order);
		if (nfce == null) {
			throw new NfceNotFoundException("No Nfce associated with the informed order was found");
		}
		return nfce;

	}

	@Transactional
	public synchronized Cart createCartOrFail(Long storeId, Long customerId) {
		Store store = findStoreOrfail(storeId);
		Customer customer = findCustomerOrFail(customerId);
		Cart cart = findByStoreAndUserAndCartStatusOrFail(store, customer, CartStatus.OPEN);
		if (cart != null) {
			throw new CartCreationProhibitionException();
		} else {
			return createCart(store, customer);
		}

	}

	public synchronized void deleteItemOrFail(@Positive @NotNull Long itemId) {
		Item item = findItemByIdOrFail(itemId);
		Cart cart = item.getCart();
		Store store = cart.getStore();
		Order order = item.getOrder();
		Product product = item.getProduct();
		if (isClose(cart)) {
			throw new CloseCartException("Unable to subtract or delete item because cart is closed");
		}
		if (order != null) {
			throw new ItemRemovalNotAllowedException();
		}
		Integer quantity = item.getQuantity();
		Stock stock = stockRepository.findByStoreAndProduct(store, product);
		stock.setAvailableQuantity(stock.getAvailableQuantity() + quantity);
		stockRepository.save(stock);
		cart.getItemsSet().remove(item);
		cartRepository.save(cart);
		itemRepository.delete(item);

	}

	public synchronized void deleteItemsOrFail(@Positive @NotNull Long cartId) {
		Cart cart = findCartByIdOrFail(cartId);
		if (isClose(cart)) {
			throw new CloseCartException("Unable to subtract or delete item because cart is closed");
		}
		for (Item item : cart.getItemsSet()) {
			Integer quantity = item.getQuantity();
			Stock stock = stockRepository.findByStoreAndProduct(item.getCart().getStore(), item.getProduct());
			stock.setAvailableQuantity(stock.getAvailableQuantity() + quantity);
			stockRepository.save(stock);
			itemRepository.delete(item);
		}
		cart.getItemsSet().clear();
		;
		cartRepository.save(cart);
	}

	public synchronized Cart createOrUpdateItemOrFail(@NotNull @Positive Long productId, Long cartId,
			@NotNull @PositiveOrZero Integer quantity) {
		Cart cart = findCartByIdOrFail(cartId);
		Product product = findProductOrFail(productId);
		if (isClose(cart)) {
			throw new CloseCartException(cartId);
		} else {
			Item item = findItemByProductAndCart(product, cart);
			Stock stock = stockRepository.findByStoreAndProduct(cart.getStore(), product);
			if (item == null) {
				if (quantity == 0) {
					return cart;
				} else {
					if (stock.getAvailableQuantity() >= quantity) {
						stock.setAvailableQuantity(stock.getAvailableQuantity() - quantity);
						stockRepository.save(stock);
						item = new Item();
						item.setCart(cart);
						item.setPrice(product.getSalePrice());
						item.setQuantity(quantity);
						item.setProduct(product);
						itemRepository.save(item);
						cart.getItemsSet().add(item);
						cartRepository.save(cart);
					} else {
						throw new StockInsufficientQuantityException(cart.getStore().getId(), product.getId());
					}
				}
			} else {

				if (item.getQuantity() == quantity) {
					return cart;
				}

				else if (item.getQuantity() < quantity) {
					Integer diff = quantity - item.getQuantity();
					if (stock.getAvailableQuantity() >= diff) {
						stock.setAvailableQuantity(stock.getAvailableQuantity() - diff);
					} else {
						throw new StockInsufficientQuantityException(cart.getStore().getId(), product.getId());
					}

				} else {
					Integer diff = item.getQuantity() - quantity;
					stock.setAvailableQuantity(stock.getAvailableQuantity() + diff);
				}
				stockRepository.save(stock);
				item.setQuantity(quantity);
				itemRepository.save(item);
				if (item.getQuantity() == 0) {
					cart.getItemsSet().remove(item);
					itemRepository.delete(item);
				}
				cartRepository.save(cart);
			}
		}
		return cart;
	}

	@Transactional
	public synchronized Order checkoutOrFail(Long cartId, Integer shippingMethodId, Long deliveryAddressId,
			Integer paymentMethodId, Long paymentObjectId, String cvv, Integer installmentsNumber,
			BigDecimal deductedDigitalAccountAmount, Integer productShortageCaseActionId) {
		ProductShortageCaseAction productShortageCaseAction = findByProductShortageCaseActionByIdOrFail(
				productShortageCaseActionId);
		Cart cart = findCartByIdOrFail(cartId);
		if (cart.isEmpty()) {
			throw new EmptyCartException(cart.getId());
		}
		if (isClose(cart)) {
			throw new CloseCartException(cartId);
		}
		Store store = cart.getStore();
		ShippingMethodChosenByCustomer shippingMethodChosenByCustomer  = findShippingMethodChosenByCustomer(shippingMethodId);
		if (!store.isSuperted(shippingMethodChosenByCustomer)) {
			throw new DeliveryMethodDontAcceptedException(store.getId(), shippingMethodId);
		}
		DeliveryAddress deliveryAddress = null;
		if (shippingMethodChosenByCustomer  == ShippingMethodChosenByCustomer.DELIVERY) {
			deliveryAddress = findDeliveryAddressByIdorFail(deliveryAddressId);
		}

		PaymentMethod paymentMethod = findPaymentMethodBydIdOrFail(paymentMethodId);
		PaymentObject paymentObject = null;
		String pixKey = null;
		if (paymentMethod == PaymentMethod.PIX_ONLY) {
			pixKey = bankService.payByPix(cart.getTotalPayable());
		} else {
			paymentObject = findPaymentObjectByIdOrFail(paymentObjectId);
			if (paymentMethod == PaymentMethod.DIGITAL_ACCOUNT_ONLY) {
				bankService.payByDigitalAccount(cart.getCustomer().getId(), cart.getTotalPayable());
			}
			if (paymentMethod == PaymentMethod.PIX_AND_DIGITAL_ACCOUNT) {
				bankService.payByDigitalAccount(cart.getCustomer().getId(), deductedDigitalAccountAmount);
				pixKey = bankService.payByPix(cart.getTotalPayable().subtract(deductedDigitalAccountAmount));
			}
			if (paymentMethod == PaymentMethod.CREDIT_CARD_ONLY) {
				CreditCard creditCard = (CreditCard) paymentObject;
				bankService.payByCreditCard(creditCard.getCardPrintedName(), creditCard.getCardNumber(),
						creditCard.getCardExpirationDate(), cvv, cart.getTotalPayable());
			}
			if (paymentMethod == PaymentMethod.CREDIT_CARD_AND_DIGITAL_ACCOUNT) {
				bankService.payByDigitalAccount(cart.getCustomer().getId(), deductedDigitalAccountAmount);
				CreditCard creditCard = (CreditCard) paymentObject;
				bankService.payByCreditCard(creditCard.getCardPrintedName(), creditCard.getCardNumber(),
						creditCard.getCardExpirationDate(), cvv,
						cart.getTotalPayable().subtract(deductedDigitalAccountAmount));
			}
			if (paymentMethod == PaymentMethod.FOOD_CARD_ONLY) {
				FoodCard foodCard = (FoodCard) paymentObject;
				bankService.payByFoodCard(foodCard.getCardPrintedName(), foodCard.getCardNumber(),
						foodCard.getCardExpirationDate(), foodCard.getCvv(), cart.getTotalPayable());
			}
			if (paymentMethod == PaymentMethod.FOOD_CARD_AND_DIGITAL_ACCOUNT) {
				bankService.payByDigitalAccount(cart.getCustomer().getId(), deductedDigitalAccountAmount);
				FoodCard foodCard = (FoodCard) paymentObject;
				bankService.payByFoodCard(foodCard.getCardPrintedName(), foodCard.getCardNumber(),
						foodCard.getCardExpirationDate(), foodCard.getCvv(),
						cart.getTotalPayable().subtract(deductedDigitalAccountAmount));
			}
		}
		return createOrder(cart, shippingMethodChosenByCustomer, deliveryAddress, paymentMethod, paymentObject, installmentsNumber,
				deductedDigitalAccountAmount, pixKey, productShortageCaseAction);
	}

	private ShippingMethodChosenByCustomer findShippingMethodChosenByCustomer(Integer shippingMethodId) {
		return ShippingMethodChosenByCustomer.valueOf(shippingMethodId);
	}

	private Store findStoreOrfail(Long id) {
		return storeRepository.findById(id).orElseThrow(() -> new StoreNotFoundException(id));
	}

	private Order findOrderOrFail(Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
	}

	private Item findItemByIdOrFail(Long id) {
		return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}

	private Customer findCustomerOrFail(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
	}

	private Cart findByStoreAndUserAndCartStatusOrFail(Store Store, Customer customer, CartStatus cartStatus) {
		return cartRepository.findByStoreAndCustomerAndCartStatus(Store, customer, cartStatus);
	}

	private Cart createCart(Store store, Customer customer) {
		Cart cart = new Cart(CartStatus.OPEN, customer, store);
		Cart persistedCart = cartRepository.save(cart);
		return persistedCart;
	}

	private Product findProductOrFail(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
	}

	private DeliveryAddress findDeliveryAddressByIdorFail(Long id) {
		return deliveryAddressRepository.findById(id)
				.orElseThrow(() -> new DeliveryAddressNotFoundNotFoundException(id));
	}

	private CreditCard findCreditCardById(Long id) {
		return creditCardRepository.findById(id).orElseThrow(() -> new CreditCardNotFoundException(id));
	}

	private PaymentObject findPaymentObjectByIdOrFail(Long id) {
		return paymentObjectRepository.findById(id).orElseThrow(() -> new PaymentObjectNotFoundException(id));
	}

	private FoodCard findFoodCardById(Long id) {
		return foodCardRepository.findById(id).orElseThrow(() -> new FoodCardNotFoundException(id));
	}

	private ProductShortageCaseAction findByProductShortageCaseActionByIdOrFail(Integer id) {
		try {
			return ProductShortageCaseAction.valueOf(id);
		} catch (IllegalArgumentException e) {
			throw new ProductShortageCaseActionException(id);
		}

	}

	private PaymentMethod findPaymentMethodBydIdOrFail(Integer id) {
		try {
			return PaymentMethod.valueOf(id);
		} catch (IllegalArgumentException e) {
			throw new ProductShortageCaseActionException(id);
		}

	}

	private DeliveryMethodSupportedByStore findByShipmentWayByIdOrFail(Integer id) {
		try {
			return DeliveryMethodSupportedByStore.valueOf(id);
		} catch (IllegalArgumentException e) {
			throw new ProductShortageCaseActionException(id);
		}

	}

	private boolean isClose(Cart cart) {
		if (cart.getCartStatus() == CartStatus.CLOSE) {
			return true;
		} else {
			return false;
		}
	}

	private Item findItemByProductAndCart(Product product, Cart cart) {
		return itemRepository.findByProductAndCart(product, cart);
	}

	private Order createOrder(Cart cart, ShippingMethodChosenByCustomer shippingMethodChosenByCustomer, DeliveryAddress deliveryAddress,
			PaymentMethod paymentMethod, PaymentObject paymentObject, Integer installmentsNumber,
			BigDecimal amountPaidByDigitalAccount, String pixKey, ProductShortageCaseAction productShortageCaseAction) {
		Order order = new Order();
		order.setCustomer(cart.getCustomer());
		order.setStore(cart.getStore());
		order.setCart(cart);
		order.getPixKey();
		order.setShippingMethodChosenByCustomer(shippingMethodChosenByCustomer);
		if (shippingMethodChosenByCustomer == ShippingMethodChosenByCustomer.DELIVERY) {
			order.setDeliveryAddress(deliveryAddress);
			order.setFixedShipping(cart.getStore().getCustomFixedShipping());
		}
		order.setGeneretedTimestamp(Instant.now());
		order.getItemsSet().addAll(cart.getItemsSet());
		order.setPaymentMethod(paymentMethod);
		order.setPaymentObject(paymentObject);
		order.setProductShortageCaseAction(productShortageCaseAction);
		order.setOrderStatus(OrderStatus.CREATED_ORDER);
		order.setGeneretedTimestamp(Instant.now());
		cart.setCartStatus(CartStatus.CLOSE);
		cartRepository.save(cart);
		if (paymentMethod == PaymentMethod.DIGITAL_ACCOUNT_ONLY) {
			order.setAmountPaidByDigitalAccount(amountPaidByDigitalAccount);
		} else if (paymentMethod == PaymentMethod.CREDIT_CARD_ONLY) {
			order.setAmountPaidByCreditCard(cart.getTotalPayable());
			order.setInstallmentsNumber(installmentsNumber);
		} else if (paymentMethod == PaymentMethod.CREDIT_CARD_AND_DIGITAL_ACCOUNT) {
			order.setAmountPaidByDigitalAccount(amountPaidByDigitalAccount);
			order.setInstallmentsNumber(installmentsNumber);
			order.setAmountPaidByCreditCard(cart.getTotalPayable().subtract(amountPaidByDigitalAccount));
		} else if (paymentMethod == PaymentMethod.FOOD_CARD_ONLY) {
			order.setAmountPaidByFoodCard(cart.getTotalPayable());
		} else if (paymentMethod == PaymentMethod.FOOD_CARD_AND_DIGITAL_ACCOUNT) {
			order.setAmountPaidByDigitalAccount(amountPaidByDigitalAccount);
			order.setAmountPaidByFoodCard(cart.getTotalPayable().subtract(amountPaidByDigitalAccount));
		}
		for (Item item : cart.getItemsSet()) {
			item.setOrder(order);
			itemRepository.save(item);
		}
		order.setTotalDiscountAmount(order.calculateTotalDiscountAmount());
		order.setTotalOrderAmount(order.calculateTotalOrderAmount());
		order.setSubtotal(order.calculateSubTotal());
		order.setProductsQuantity(order.calculateProductsQuantity());
		order.setItemQuantity(order.calculateItemsQuantity());
		order.setCashBackAmount(order.calculateCashBackAmmount());
		order = orderRepository.save(order);
		cart.setOrder(order);
		cartRepository.save(cart);
		if (deliveryAddress != null) {
			deliveryAddress.getOrdersSet().add(order);
			deliveryAddressRepository.save(deliveryAddress);
		}
		UpdateOrderStatusTimerTask updateOrderStatusTimerTask = new UpdateOrderStatusTimerTask(order.getId(),
				cart.getId(), orderRepository, stockRepository, cartRepository, sefazService, bankService);
		timer.schedule(updateOrderStatusTimerTask, orderUpdateIntervalInMiliseconds, orderUpdateIntervalInMiliseconds);
		return order;
	}
	

}
