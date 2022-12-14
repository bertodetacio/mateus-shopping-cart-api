package br.com.mateus.shoppingcart.core.dbconfig;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.mateus.shoppingcart.domain.exceptions.StockInsufficientQuantityException;
import br.com.mateus.shoppingcart.domain.model.Branding;
import br.com.mateus.shoppingcart.domain.model.BusinessAddress;
import br.com.mateus.shoppingcart.domain.model.Cart;
import br.com.mateus.shoppingcart.domain.model.Category;
import br.com.mateus.shoppingcart.domain.model.City;
import br.com.mateus.shoppingcart.domain.model.Contract;
import br.com.mateus.shoppingcart.domain.model.CreditCard;
import br.com.mateus.shoppingcart.domain.model.Danfe;
import br.com.mateus.shoppingcart.domain.model.DeliveryAddress;
import br.com.mateus.shoppingcart.domain.model.Department;
import br.com.mateus.shoppingcart.domain.model.DigitalAccount;
import br.com.mateus.shoppingcart.domain.model.FoodCard;
import br.com.mateus.shoppingcart.domain.model.IndividualCustomer;
import br.com.mateus.shoppingcart.domain.model.Item;
import br.com.mateus.shoppingcart.domain.model.Nfce;
import br.com.mateus.shoppingcart.domain.model.Order;
import br.com.mateus.shoppingcart.domain.model.Product;
import br.com.mateus.shoppingcart.domain.model.Section;
import br.com.mateus.shoppingcart.domain.model.State;
import br.com.mateus.shoppingcart.domain.model.Stock;
import br.com.mateus.shoppingcart.domain.model.Store;
import br.com.mateus.shoppingcart.domain.model.enums.CartStatus;
import br.com.mateus.shoppingcart.domain.model.enums.DeliveryAddressLabel;
import br.com.mateus.shoppingcart.domain.model.enums.DeliveryMethodSupportedByStore;
import br.com.mateus.shoppingcart.domain.model.enums.OrderStatus;
import br.com.mateus.shoppingcart.domain.model.enums.PaymentMethod;
import br.com.mateus.shoppingcart.domain.model.enums.ProductShortageCaseAction;
import br.com.mateus.shoppingcart.domain.model.enums.ShippingMethodChosenByCustomer;
import br.com.mateus.shoppingcart.domain.repositories.BrandingRepository;
import br.com.mateus.shoppingcart.domain.repositories.CartRepository;
import br.com.mateus.shoppingcart.domain.repositories.CategoryRepository;
import br.com.mateus.shoppingcart.domain.repositories.CityRepository;
import br.com.mateus.shoppingcart.domain.repositories.CreditCardRepository;
import br.com.mateus.shoppingcart.domain.repositories.DanfeRepository;
import br.com.mateus.shoppingcart.domain.repositories.DeliveryAddressRepository;
import br.com.mateus.shoppingcart.domain.repositories.DepartmentRepository;
import br.com.mateus.shoppingcart.domain.repositories.DigitalAccountRepository;
import br.com.mateus.shoppingcart.domain.repositories.FoodCardRepository;
import br.com.mateus.shoppingcart.domain.repositories.IndividualCustomerRepository;
import br.com.mateus.shoppingcart.domain.repositories.ItemRepository;
import br.com.mateus.shoppingcart.domain.repositories.NfceRepository;
import br.com.mateus.shoppingcart.domain.repositories.OrderRepository;
import br.com.mateus.shoppingcart.domain.repositories.ProductRepository;
import br.com.mateus.shoppingcart.domain.repositories.SectionRepository;
import br.com.mateus.shoppingcart.domain.repositories.StateRepository;
import br.com.mateus.shoppingcart.domain.repositories.StockRepository;


@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

	
	@Autowired
	private IndividualCustomerRepository individualCustomerRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private DeliveryAddressRepository deliveryAddressRepository;

	@Autowired
	private CreditCardRepository creditCardRepository;

	@Autowired
	private SectionRepository sectionRepository;

	@Autowired
	private BrandingRepository brandingRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private DigitalAccountRepository digitalAccountRepository;

	@Autowired
	private NfceRepository nfceRepository;

	@Autowired
	private DanfeRepository danfeRepository;
	
	@Autowired
	FoodCardRepository foodCardRepository;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("##################Seeding database...#########################");
		
		
		//Contrato obrigat??rio para cria????ode conta de usu??rio
		Contract contract = new Contract();
		contract.setAgreePrivacyPolicy(true);
		contract.setAgreeTermsOfUse(true);
		contract.setNotifyOrderStatusByWhatsapp(true);
		contract.setNotifyPromotionsByEmail(true);
		contract.setNotifyPromotionsBySms(true);
		
		//Conta de consumidor do tipo pessoa f??sica
		IndividualCustomer individualCustomer = new IndividualCustomer();
		individualCustomer.setFirstName("Berto");
		individualCustomer.setMiddleName("De T??cio Pereira");
		individualCustomer.setLastName("Gomes");
		individualCustomer.setCpf("013.939.423-00");
		individualCustomer.setPhone("(98) 98811-9435");
		individualCustomer.setEmail("bertotdeacio@gmail.com");
		individualCustomer.setDateOfBirth(LocalDate.of(1985, 9, 10));
		individualCustomer.setPassword("4gd75jhs94hhs78390j933");
		individualCustomer.setAccountNonExpired(true);
		individualCustomer.setAccountNonLocked(true);
		individualCustomer.setCredentialsNonExpired(true);
		individualCustomer.setContract(contract);
		contract.setCustomer(individualCustomer);
		IndividualCustomer individualCustomerPersisted = individualCustomerRepository.save(individualCustomer);
		IndividualCustomer individualCustomerFounded = individualCustomerRepository
				.findById(individualCustomerPersisted.getId()).get();
	
		//Conta digital 
		DigitalAccount digitalAccount = new DigitalAccount();
		digitalAccount.setCustomer(individualCustomerFounded);
		digitalAccount.deposit(new BigDecimal(11.00));
		DigitalAccount digitalAccountPersisted = digitalAccountRepository.save(digitalAccount);
		DigitalAccount digitalAccountFounded = digitalAccountRepository.findById(digitalAccountPersisted.getId()).get();
	
		individualCustomerFounded.setDigitalAccount(digitalAccountFounded);
		individualCustomerFounded = individualCustomerRepository.save(individualCustomerFounded);

		State state = new State();
		state.setName("Maranh??o");
		state.setAcronym("MA");
		State statePersisted = stateRepository.save(state);
		State stateFounded = stateRepository.findById(statePersisted.getId()).get();
	

		City city = new City();
		city.setName("S??o Jos?? de Ribamar");
		city.setState(stateFounded);
		City cityPersisted = cityRepository.save(city);
		City cityFounded = cityRepository.findById(cityPersisted.getId()).get();
	
		DeliveryAddress deliveryAddress = new DeliveryAddress();
		deliveryAddress.setStreet("Avenida Garrastazu M??dice");
		deliveryAddress.setHouseNumber(143);
		deliveryAddress.setDistrict("Campina");
		deliveryAddress.setCep("65110-000");
		deliveryAddress.setComplement("Pr??ximo ?? Metalugica");
		deliveryAddress.setDeliveryAddressLabel(DeliveryAddressLabel.HOME);
		deliveryAddress.setCustomer(individualCustomerFounded);
		deliveryAddress.setCity(cityFounded);
		deliveryAddress.setDeliveryAddressLabel(DeliveryAddressLabel.OTHER);
		DeliveryAddress deliveryAddressPersisted = deliveryAddressRepository.save(deliveryAddress);
		DeliveryAddress deliveryAddressFounded = deliveryAddressRepository.findById(deliveryAddressPersisted.getId())
				.get();
	
		CreditCard creditCard = new CreditCard();
		creditCard.setCardPrintedName("BERTO TACIO P GOMES");
		creditCard.setCardNumber("4984074125988177");
		creditCard.setCardExpirationDate("02/22");
		creditCard.setCustomer(individualCustomerFounded);
		CreditCard creditCardPersisted = creditCardRepository.save(creditCard);
		CreditCard creditCardFounded = creditCardRepository.findById(creditCardPersisted.getId()).get();
	
		
		FoodCard foodCard = new FoodCard();
		foodCard.setCardPrintedName("BERTO TACIO P GOMES");
		foodCard.setCardNumber("4984074126552501");
		foodCard.setCardExpirationDate("02/22");
		foodCard.setCustomer(individualCustomerFounded);
		FoodCard foodCardPersisted = foodCardRepository.save(foodCard);
		FoodCard foodCardFounded = foodCardRepository.findById(foodCardPersisted.getId()).get();
		
		City cityStore = new City();
		cityStore.setName("S??o Lu??s");
		cityStore.setState(stateFounded);
		City cityStorePersisted = cityRepository.save(cityStore);
		City cityStoreFounded = cityRepository.findById(cityStorePersisted.getId()).get();
	
		BusinessAddress businessAddress = new BusinessAddress();
		businessAddress.setStreet("Avenida Mon????o");
		businessAddress.setHouseNumber(2);
		businessAddress.setDistrict("Renascenca");
		businessAddress.setCep("65075-692");
		businessAddress.setComplement("Em frente ao Edif??cio Mont Blanc");
		businessAddress.setCity(cityStoreFounded);

		Category category = new Category();
		category.setName("Supermercado/Hipermercado");
		Category categoryPersisted = categoryRepository.save(category);
		Category categoryFounded = categoryRepository.findById(categoryPersisted.getId()).get();
	

		Store store = new Store();
		store.setFantasyName("Mateus Renascen??a");
		store.setLegallName("Mateus Supermercados S.a.");
		store.setCnpj("03.995.515/0082-22");
		store.setCorporateEmail("contabilidade@armateus.com.br");
		store.setCorporatePhone("(98) 2108-3582");
		store.setKilometerPrice(new BigDecimal(0.00));
		store.setStateRegistration("122255518");
		store.setStateRegistrationExempt(false);
		//Valor simb??lico de frete
		store.setCustomFixedShipping(new BigDecimal(1.00));
		//zero devido ao frete fixo
		store.setKilometerPrice(new BigDecimal(0.00));
		businessAddress.setCompany(store);
		store.setBusinessAddress(businessAddress);
		store.setCategory(categoryFounded);
		store.setDeliveryMethodSupportedByStore(DeliveryMethodSupportedByStore.DELIVERY_AND_PICKUP);
		category.getStoresSet().add(store);
		//Departamento ?? como se fosse uma cateogria de produto
		Department department = new Department();
		department.setCode(2345L);
		department.setName("Alimentos n??o perec??veis");
		department.getStoresSet().add(store);
		store.getDepartmentsSet().add(department);
		Department departmentPersisted = departmentRepository.save(department);
		Department departmentFounded = departmentRepository.findById(departmentPersisted.getId()).get();
	
		
		// Se????o ?? como se fosse uma subcategoria de produto
		Section section = new Section();
		section.setName("Parbolizados");
		section.setCode(6464646L);
		section.setDepartment(departmentFounded);
		
		//marca do produto
		Branding branding = new Branding();
		branding.setDescription("Tio Jo??o");
		Branding brandingPersisted = brandingRepository.save(branding);
		Branding brandingFounded = brandingRepository.findById(brandingPersisted.getId()).get();
		
		
		//cadastro do produto
		Product product = new Product();
		product.setName("Arroz Integral Parboilizado Tipo 1 1kg");
		product.setShortDescription("Arroz Tio Jo??o 1kg");
		product.setLongDescription("Arroz Integral Parboilizado Tipo 1 1kg. Produto com gr??os selecionados e de altissima qualidade");
		product.setBranding(brandingFounded);
		product.setEan("7893500018483");
		product.setSku(37625L);
		product.setUnit("Unidade");
		product.setUnitRegularPrice(new BigDecimal(10.00));
		product.setUnitSalePrice(new BigDecimal(10.00));
		product.setMinimumOrderQuantity(1);
		product.setImageUrl("http://localhost/images/arroz-tiojoao");
		product.getSectionsSet().add(section);
		section.getProductsSet().add(product);
		product.setCashbackPercentage(new BigDecimal(1.00));
		Product productPersisted = productRepository.save(product);
		Product productFounded = productRepository.findById(productPersisted.getId()).get();
	

		Section sectionPersisted = sectionRepository.save(section);
		Section sectionFounded = sectionRepository.findById(sectionPersisted.getId()).get();
	
			
		//quantidade em estoque
		Stock stock = new Stock(store, productFounded, 100);
		stockRepository.save(stock);
		
		//simulando a cria????o do carrinho
		Cart cart = new Cart();
		cart.setCustomer(individualCustomerFounded);
		cart.setStore(store);
		cart.setCartStatus(CartStatus.OPEN);
		Cart cartPersisted = cartRepository.save(cart);
		Cart cartFounded = cartRepository.findById(cartPersisted.getId()).get();
	

		//inser????o dos item no carrinho
		Item item = new Item();
		item.setCart(cartFounded);
		item.setProduct(productFounded);
		item.setQuantity(10);
		item.setPrice(productFounded.getSalePrice());
		
		//atualiza???? do estoque
		if (stock.getAvailableQuantity() < item.getQuantity()) {
			throw new StockInsufficientQuantityException(store.getId(), product.getId());
		} else {
			stock.setAvailableQuantity(stock.getAvailableQuantity() - item.getQuantity());
			stockRepository.save(stock);
		}

		Item itemPeristed = itemRepository.save(item);
		Item itemFounded = itemRepository.findById(itemPeristed.getId()).get();
	

		//cria????o do pedido com as informa????es do cliente, produto, itens, forma de pagamento e etc
		Order order = new Order();
		order.getItemsSet().add(itemFounded);
		order.setFixedShipping(store.getCustomFixedShipping());
		order.setTotalDiscountAmount(order.calculateTotalDiscountAmount());
		order.setTotalOrderAmount(order.calculateTotalOrderAmount());
		order.setSubtotal(order.calculateSubTotal());
		order.setProductsQuantity(order.calculateProductsQuantity());
		order.setItemQuantity(order.calculateItemsQuantity());
		order.setCashBackAmount(order.calculateCashBackAmmount());
		order.setFixedShipping(store.getCustomFixedShipping());
		order.setCustomer(individualCustomerFounded);
		order.setGeneretedTimestamp(Instant.now());
		order.setShippingMethodChosenByCustomer(ShippingMethodChosenByCustomer.DELIVERY);
		order.setOrderStatus(OrderStatus.CREATED_ORDER);
		order.setGeneretedTimestamp(Instant.now());
		order.setOrderStatus(OrderStatus.ORDER_UNDER_REVIEW);
		order.setUnderReviewTimestamp(Instant.now());
		if (order.getShippingMethodChosenByCustomer() == ShippingMethodChosenByCustomer.PICKUP_STORE) {
			order.setDeliveryAddress(null);
		}
		else {
			order.setDeliveryAddress(deliveryAddressFounded);
		}
		order.setStore(store);
			order.getItemsSet().add(itemFounded);
		order.setPaymentMethod(PaymentMethod.CREDIT_CARD_ONLY);
		order.setPaymentObject(creditCardFounded);
		order.setAmountPaidByCreditCard(order.getTotalOrderAmount());
		order.setProductShortageCaseAction(ProductShortageCaseAction.RECEIVE_A_CALL);
		order.setCart(cartFounded);
		Order orderPersisted = orderRepository.save(order);
		Order orderFounded = orderRepository.findById(orderPersisted.getId()).get();
		itemFounded.setOrder(orderFounded);

		itemRepository.save(itemFounded);
	
		// atuliza o status do carrinho
		cartFounded.setCartStatus(CartStatus.CLOSE);
		cartRepository.save(cartFounded);

		// Simula a consulta ao banco

		// atualiza status do pedido para pago
		orderFounded.setOrderStatus(OrderStatus.AUTHORIZED_ORDER_PAYMENT);
		orderFounded.setAuthorizedPaymentTimestamp(Instant.now());
		orderFounded.setReadyForDeliveryTimestamp(Instant.now());
		orderFounded.setOrderStatus(OrderStatus.ORDER_IN_SEPARATION);
		orderFounded.setSeparationTimestamp(Instant.now());
		orderFounded.setUnderReviewTimestamp(Instant.now());
		orderFounded.setOrderStatus(OrderStatus.ORDER_READY_FOR_DELIVERY);
		orderFounded.setDeliveredTimestamp(Instant.now());
		orderFounded.setOrderStatus(OrderStatus.ORDER_DELIVERED);
		orderFounded = orderRepository.save(orderFounded);

		/*
		 * for (Item item2 : order.getItemsSet()) { Product product2 =
		 * item.getProduct(); Stock stock2 =
		 * stockRepository.findByStoreAndProduct(store, product2); int currentQuantity =
		 * stock2.getAvailableQuantity(); if (currentQuantity >= item.getQuantity()) {
		 * stock.setAvailableQuantity(currentQuantity - item2.getQuantity()); } else {
		 * throw new StockInsufficientQuantityException(store.getId(), product.getId());
		 * } }
		 */

		//Gera????o da nota fiscal
		Nfce nfce = new Nfce();
		nfce.setNumber(1234L);
		nfce.setModel(65L);
		nfce.setSerie(192L);
		nfce.setIssueTimestamp(Instant.now());
		nfce.setArrivalDepartureTimestamp(Instant.now());
		nfce.setModel(65L);
		nfce.setTotalInvoiceAmount(order.calculateTotalOrderAmount());
		nfce.setCustomer(individualCustomerFounded);
		nfce.setOrder(orderFounded);
		Nfce nfcePersisted = nfceRepository.save(nfce);
		Nfce nfceFounded = nfceRepository.findById(nfcePersisted.getId()).get();

		//Gera????o da nota Danfe
		Danfe danfe = new Danfe();
		danfe.setAccessKey("1224 1234 5678 9098 1234 12345 1234567 8908");
		danfe.setNumber(4567L);
		danfe.setXmlVersion(4.0);
		danfe.setNfce(nfceFounded);
		danfe.setCustomer(individualCustomerFounded);
		danfe.setOrder(orderFounded);
		danfe.getItemsSet().addAll(order.getItemsSet());
		Danfe danfePersisted = danfeRepository.save(danfe);
		Danfe danfeFounded = danfeRepository.findById(danfePersisted.getId()).get();
	
		danfeRepository.save(danfeFounded);
		itemFounded.setDanfe(danfePersisted);
		itemRepository.save(itemFounded);
		orderFounded.setDanfe(danfeFounded);
		orderFounded.setNfce(nfceFounded);
		orderRepository.save(orderFounded);
		
		System.out.println("#################Seeded database#########################");
	}
}
