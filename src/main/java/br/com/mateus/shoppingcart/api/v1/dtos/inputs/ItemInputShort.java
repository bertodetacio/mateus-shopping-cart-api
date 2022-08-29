package br.com.mateus.shoppingcart.api.v1.dtos.inputs;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemInputShort {

	@Valid
	@NotNull
	@Schema (example = "1")
	private Integer quantity;
	
}