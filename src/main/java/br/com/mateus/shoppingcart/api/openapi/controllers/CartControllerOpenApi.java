package br.com.mateus.shoppingcart.api.openapi.controllers;

import org.springframework.hateoas.CollectionModel;

import br.com.mateus.shoppingcart.api.v1.dtos.model.CartModelShort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Carts")
public interface CartControllerOpenApi {

	@Operation(summary = "Find all Carts.", responses = {
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	public CollectionModel<CartModelShort> findAllCarts();

	@Operation(summary = "Find Cart by id", responses = {
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	CartModelShort findCartById(Long cartId);

}
