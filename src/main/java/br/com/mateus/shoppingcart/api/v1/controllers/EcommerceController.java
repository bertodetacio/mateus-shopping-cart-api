package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.ResourceUriHelper;
import br.com.mateus.shoppingcart.api.openapi.controllers.EcommerceControlerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.CartModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.DanfeModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.NfceModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.OrderModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.inputs.CheckoutInput;
import br.com.mateus.shoppingcart.api.v1.dtos.inputs.ItemInputShort;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CartModelShort;
import br.com.mateus.shoppingcart.api.v1.dtos.model.DanfeModelShort;
import br.com.mateus.shoppingcart.api.v1.dtos.model.NfceModelShort;
import br.com.mateus.shoppingcart.api.v1.dtos.model.OrderModelShort;
import br.com.mateus.shoppingcart.domain.model.Cart;
import br.com.mateus.shoppingcart.domain.model.Danfe;
import br.com.mateus.shoppingcart.domain.model.Nfce;
import br.com.mateus.shoppingcart.domain.model.Order;
import br.com.mateus.shoppingcart.domain.services.EcommerceService;

@RestController
@RequestMapping(path = "api/v1/e-commerce", produces = MediaType.APPLICATION_JSON_VALUE)
public class EcommerceController implements EcommerceControlerOpenApi {

	@Autowired
	private EcommerceService ecommerceService;

	@Autowired
	private CartModelShortAssembler cartModelShortAssembler;

	@Autowired
	private OrderModelShortAssembler orderModelShortAssembler;

	@Autowired
	private DanfeModelShortAssembler danfeModelShortAssembler;
	
	@Autowired
	private NfceModelShortAssembler nfceModelShortAssembler;

	@Override
	@ResponseStatus(code = (HttpStatus.OK))
	@GetMapping(path = "/carts/{cartId}")
	public CartModelShort findCartById(@PathVariable(name = "cartId", required = true) Long cartId) {
		Cart cart = ecommerceService.findCartByIdOrFail(cartId);
		CartModelShort cartModelShort = cartModelShortAssembler.toModel(cart);
		return cartModelShort;
	}

	@Override
	@ResponseStatus(code = (HttpStatus.OK))
	@GetMapping(path = "/carts")
	public CollectionModel<CartModelShort> findAllCarts() {
		List<Cart> cartsList = ecommerceService.findAllCarts();
		return cartModelShortAssembler.toCollectionModel(cartsList);
	}

	@Override
	@ResponseStatus(code = (HttpStatus.OK))
	@GetMapping(path = "/carts/{cartId}/orders")
	public OrderModelShort findOrderByCartdId(
			@PathVariable(name = "cartId", required = true) @Positive @NotNull Long cartId) {
		Order order = ecommerceService.findOrderByCartIdOrFail(cartId);
		return orderModelShortAssembler.toModel(order);
	}

	@Override
	@ResponseStatus(code = (HttpStatus.OK))
	@GetMapping(path = "/orders")
	public CollectionModel<OrderModelShort> findAllOrders() {
		List<Order> ordersList = ecommerceService.findAllOrders();
		return orderModelShortAssembler.toCollectionModel(ordersList);
	}

	@Override
	@ResponseStatus(code = (HttpStatus.OK))
	@GetMapping(path = "/orders/{orderId}")
	public OrderModelShort findOrderBydId(
			@PathVariable(name = "orderId", required = true) @Positive @NotNull Long orderId) {
		Order order = ecommerceService.findOrderByIdOrFail(orderId);
		OrderModelShort orderModelShort = orderModelShortAssembler.toModel(order);
		return orderModelShort;
	}
	
	
	@Override
	@ResponseStatus(code = (HttpStatus.OK))
	@GetMapping(path = "/orders/{orderId}/danfes")
	public DanfeModelShort findDanfeByOrderId(
			@PathVariable(name = "orderId", required = true) @Positive @NotNull Long orderId) {
		Danfe danfe = ecommerceService.findDanfeByOrderIdOrFail(orderId);
		return danfeModelShortAssembler.toModel(danfe);
	}
	
	@Override
	@ResponseStatus(code = (HttpStatus.OK))
	@GetMapping(path = "/orders/{orderId}/nfces")
	public NfceModelShort findNfceByOrderId(
			@PathVariable(name = "orderId", required = true) @Positive @NotNull Long orderId) {
		Nfce nfce = ecommerceService.findNfceByOrderIdOrFail(orderId);
		return nfceModelShortAssembler.toModel(nfce);
	}

	@Override
	@ResponseStatus(code = (HttpStatus.OK))
	@GetMapping(path = "/customers/{customerId}/orders")
	public CollectionModel<OrderModelShort> findOrderByCustomerdId(
			@PathVariable(name = "customerId", required = true) @Positive @NotNull Long customerId) {
		List<Order> ordersList = ecommerceService.findOrdersByCustomerIdOrFail(customerId);
		return orderModelShortAssembler.toCollectionModel(ordersList);
	}
	
	@Override
	@ResponseStatus(code = (HttpStatus.OK))
	@GetMapping(path = "/customers/{customerId}/carts")
	public CollectionModel<CartModelShort> findCartByCustomerdId(
			@PathVariable(name = "customerId", required = true) @Positive @NotNull Long customerId) {
		List<Cart> cartsList = ecommerceService.findCartsByCustomerIdOrFail(customerId);
		return cartModelShortAssembler.toCollectionModel(cartsList);
	}

	@Override
	@ResponseStatus(code = (HttpStatus.OK))
	@GetMapping(path = "/customers/{customerId}/danfes")
	public CollectionModel<DanfeModelShort> findDanfesByCustomerId(
			@PathVariable(name = "customerId", required = true) @Positive @NotNull Long customerId) {
		List<Danfe> danfesList = ecommerceService.findDanfesByCustomerIdOrFail(customerId);
		return danfeModelShortAssembler.toCollectionModel(danfesList);
	}
	
	@Override
	@ResponseStatus(code = (HttpStatus.OK))
	@GetMapping(path = "/customers/{customerId}/nfces")
	public CollectionModel<NfceModelShort> findNfcesByCustomerId(
			@PathVariable(name = "customerId", required = true) @Positive @NotNull Long customerId) {
		List<Nfce> nfcesList = ecommerceService.findNfcesByCustomerIdOrFail(customerId);
		return nfceModelShortAssembler.toCollectionModel(nfcesList);
	}
	

	@Override
	@ResponseStatus(code = (HttpStatus.OK))
	@GetMapping(path = "/danfes")
	public CollectionModel<DanfeModelShort> findAllDanfes() {
		List<Danfe> danfesList = ecommerceService.findAllDanfes();
		return danfeModelShortAssembler.toCollectionModel(danfesList);
	}
	
	@Override
	@ResponseStatus(code = (HttpStatus.OK))
	@GetMapping(path = "/nfces")
	public CollectionModel<NfceModelShort> findAllNfces() {
		List<Nfce> nfcesList = ecommerceService.findAllNfces();
		return nfceModelShortAssembler.toCollectionModel(nfcesList);
	}
	
	@Override
	@ResponseStatus(code = (HttpStatus.OK))
	@GetMapping(path = "/danfes/{danfId}")
	public DanfeModelShort findDanfeBydId(@PathVariable (name = "danfeId", required = true) Long danfId) {
		Danfe danfe = ecommerceService.findDanfeById(danfId);
		return danfeModelShortAssembler.toModel(danfe);
	}
	
	@Override
	@ResponseStatus(code = (HttpStatus.OK))
	@GetMapping(path = "/nfces/{danfId}")
	public NfceModelShort findNfceBydId(@PathVariable (name = "nfceId", required = true) Long danfId) {
		Nfce nfce = ecommerceService.findNfceById(danfId);
		return nfceModelShortAssembler.toModel(nfce);
	}

	@Override
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(path = "/stores/{storeId}/customers/{customerId}/carts")
	public CartModelShort createCart(@PathVariable(name = "storeId", required = true) Long storeId,
			@PathVariable(name = "customerId", required = true) Long customerId) {
		Cart cart = ecommerceService.createCartOrFail(storeId, customerId);
		CartModelShort cartModelShort = cartModelShortAssembler.toModel(cart);
		ResourceUriHelper.addUriInResponseHeader(cartModelShort.getId());
		return cartModelShort;
	}

	@Override
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(path = "/carts/{cartId}/orders")
	public OrderModelShort checkout(@PathVariable(name = "cartId", required = true) Long cartId,
			@RequestBody CheckoutInput cartCheckoutInput) {
		Order order = ecommerceService.checkoutOrFail(cartId,
				cartCheckoutInput.getShippingMethodChoseByCustomer().getId().intValue(),
				cartCheckoutInput.getDeliveryAddress().getId(),
				cartCheckoutInput.getPaymentMethod().getId().intValue(),
				cartCheckoutInput.getPaymentObject().getId(), cartCheckoutInput.getPaymentObject().getCvv(),
				cartCheckoutInput.getPaymentObject().getInstallmentsNumber(),
				cartCheckoutInput.getDigitalAccount().getDeductedDigitalAccountAmount(),
				cartCheckoutInput.getProductShortCaseAction().getId().intValue());
		OrderModelShort orderModelShort = orderModelShortAssembler.toModel(order);
		ResourceUriHelper.addUriInResponseHeader(orderModelShort.getId());
		return orderModelShort;
	}

	@Override
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping(path = "/carts/{cartId}/products/{productId}/items")
	public CartModelShort addOrUpdateItem(@PathVariable(name = "cartId", required = true) Long cartId,
			@PathVariable(name = "productId", required = true) Long productId, @RequestBody ItemInputShort item) {
		Cart cart = ecommerceService.createOrUpdateItemOrFail(productId, cartId, item.getQuantity());
		CartModelShort cartModelShort = cartModelShortAssembler.toModel(cart);
		return cartModelShort;
	}

	@Override
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "/items/{itemId}")
	public void deleteItem(@PathVariable(name = "itemId", required = true) @Positive @NotNull Long itemId) {
		ecommerceService.deleteItemOrFail(itemId);
	}

	@Override
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "/carts/{cartId}/items/")
	public void deleteAllItems(@PathVariable(name = "cartId", required = true) @Positive @NotNull Long cartId) {
		ecommerceService.deleteItemsOrFail(cartId);
	}

	@Override
	public CartModelShort findCartBydId(@Positive @NotNull Long cartId) {
		// TODO Auto-generated method stub
		return null;
	}

}
