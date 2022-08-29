package br.com.mateus.shoppingcart.api.openapi.controllers;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.hateoas.CollectionModel;

import br.com.mateus.shoppingcart.api.v1.dtos.inputs.ItemInputShort;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CartModelShort;
import br.com.mateus.shoppingcart.api.v1.dtos.model.DanfeModelShort;
import br.com.mateus.shoppingcart.api.v1.dtos.model.NfceModelShort;
import br.com.mateus.shoppingcart.api.v1.dtos.model.OrderModelShort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "E-commerce")
public interface EcommerceControlerOpenApi {

	@Operation(summary = "Checkout the Cart and generate an Order if the payment details provided are valid.", responses = {
			@ApiResponse(responseCode = "201", description = "Created order"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	OrderModelShort checkout(@Parameter(description = "Cart id", example = "1", required = true) Long cartId, @RequestBody(description = "Checkout input data")
			br.com.mateus.shoppingcart.api.v1.dtos.inputs.CheckoutInput cartCheckoutInput);


	@Operation(summary = "Find all Carts.", responses = {
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	CollectionModel<CartModelShort> findAllCarts();

	
	@Operation(summary = "Find all Orders.", responses = {
			@ApiResponse(responseCode = "20O", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	CollectionModel<OrderModelShort> findAllOrders();

	@Operation(summary = "Find Order by Customer id.", responses = {
			@ApiResponse(responseCode = "20O", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	CollectionModel<OrderModelShort> findOrderByCustomerdId(@Parameter(description = "Customer id", example = "1", required = true) @Positive @NotNull Long customerId);

	@Operation(summary = "Find all danfes.", responses = {
			@ApiResponse(responseCode = "20O", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	CollectionModel<DanfeModelShort> findAllDanfes();

	@Operation(summary = "Find Danfe by Customer id.", responses = {
			@ApiResponse(responseCode = "20O", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	CollectionModel<DanfeModelShort> findDanfesByCustomerId(@Parameter(description = "Customer id", example = "1", required = true)@Positive @NotNull Long customerId);

	@Operation(summary = "Find Danfe by Order id.", responses = {
			@ApiResponse(responseCode = "20O", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	DanfeModelShort findDanfeByOrderId(@Parameter(description = "Order id", example = "1", required = true) @Positive @NotNull Long orderId);

	@Operation(summary = "Find Order by id.", responses = {
			@ApiResponse(responseCode = "20O", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	OrderModelShort findOrderBydId(@Parameter(description = "Order id", example = "1", required = true) @Positive @NotNull Long orderId);
	
	
	@Operation(summary = "Find Order by cart id.", responses = {
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	OrderModelShort findOrderByCartdId(@Parameter(description = "Cart id", example = "1", required = true) @Positive @NotNull Long cartId);

	@Operation(summary = "Creates and opens a Cart for the Customer in the specific Store", responses = {
			@ApiResponse(responseCode = "201", description = "Created cart"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	CartModelShort createCart(@Parameter(description = "Store id", example = "1", required = true) Long storeId, @Parameter(description = "Customer id", example = "1", required = true) Long customerId);

	
	@Operation(summary = "Add Product items to Cart. If the Item already exists, just update the quantity.", responses = {
			@ApiResponse(responseCode = "200", description = "Updated cart and item"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),


	})
	CartModelShort addOrUpdateItem(@Parameter(description = "Cart  id", example = "1", required = true)Long cartId, @Parameter(description = "Product id", example = "1", required = true) Long productId, @RequestBody(description = "Input data for cart creation", required = true) ItemInputShort item);

	@Operation(summary = "Deletes the specific Product Item from the Cart to which it is linked", responses = {
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),


	})
	void deleteItem(@Parameter(description = "Item id", example = "1", required = true) Long itemId);


	@Operation(summary = "Delete all Cart Items", responses = {
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),


	})
	void deleteAllItems(@Parameter(description = "Cart id", example = "1", required = true) @Positive @NotNull Long cartId);



	@Operation(summary = "Find Cart by id.", responses = {
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	CartModelShort findCartById(Long cartId);

	
	@Operation(summary = "Find Danfe by id.", responses = {
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	DanfeModelShort findDanfeBydId(Long danfId);


	@Operation(summary = "Find all Nfces", responses = {
			@ApiResponse(responseCode = "204", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),


	})
	CollectionModel<NfceModelShort> findAllNfces();


	@Operation(summary = "Find all Nfces", responses = {
			@ApiResponse(responseCode = "204", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),


	})
	NfceModelShort findNfceBydId(Long danfId);


	@Operation(summary = "Find Nfce by Order Id", responses = {
			@ApiResponse(responseCode = "204", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),


	})
	NfceModelShort findNfceByOrderId(@Positive @NotNull Long orderId);

	
	@Operation(summary = "Find Nfces by Customer id", responses = {
			@ApiResponse(responseCode = "204", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),


	})
	CollectionModel<NfceModelShort> findNfcesByCustomerId(@Positive @NotNull Long customerId);


	@Operation(summary = "Find Cart by id", responses = {
			@ApiResponse(responseCode = "204", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),


	})
	CartModelShort findCartBydId(@Positive @NotNull Long cartId);


	


	@Operation(summary = "Find Cart by Customer id", responses = {
			@ApiResponse(responseCode = "204", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),


	})
	CollectionModel<CartModelShort> findCartByCustomerdId(@Positive @NotNull Long customerId);

}
