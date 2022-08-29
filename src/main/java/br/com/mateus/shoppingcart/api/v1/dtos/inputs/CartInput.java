package br.com.mateus.shoppingcart.api.v1.dtos.inputs;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartInput {

	@Schema(example = "Mateus Cohama")
	@NotNull
	private StoreInput store;
	
	@Schema(example = "Berto de Tácio Pereira Gomes")
	@NotNull
	private CustomerInput CustomerId;	
	
}