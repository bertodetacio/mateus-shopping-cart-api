package br.com.mateus.shoppingcart.api.openapi.controllers;

import org.springframework.hateoas.CollectionModel;

import br.com.mateus.shoppingcart.api.v1.dtos.model.FiscalDocumentModelShort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Fiscal Documents")
public interface FiscalDocumentControllerOpenApi {

	@Operation(summary = "Find all Fiscal Documents.", responses = {
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	public CollectionModel<FiscalDocumentModelShort> findAllFiscalDocuments();

	@Operation(summary = "Find Fiscal Document by id", responses = {
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = {
					@Content(schema = @Schema(ref = "Problem")) }),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = {
					@Content(schema = @Schema(ref = "Problem")) }),

	})
	FiscalDocumentModelShort findFiscalDocumentById(Long fiscalDocumentId);

}
