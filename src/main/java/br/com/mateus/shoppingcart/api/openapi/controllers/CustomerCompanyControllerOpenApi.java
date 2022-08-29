package br.com.mateus.shoppingcart.api.openapi.controllers;

import org.springframework.hateoas.CollectionModel;

import br.com.mateus.shoppingcart.api.v1.dtos.model.CustomerCompanyModelShort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Customer Companies")
public interface CustomerCompanyControllerOpenApi {

	@Operation(summary = "Find all CustomerCompanys.", responses = {
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	public CollectionModel<CustomerCompanyModelShort> findAllCustomerCompanies();

	@Operation(summary = "Find Customer Company by id", responses = {
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	CustomerCompanyModelShort findCustomerCompanyById(Long customerCompanyId);

}
