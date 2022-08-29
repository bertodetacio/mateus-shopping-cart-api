package br.com.mateus.shoppingcart.api.v1.dtos.inputs;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode (callSuper = true)
public class DigitalAccountInput extends BaseInput {

	@Schema(example = "0.00")
	private BigDecimal deductedDigitalAccountAmount;
	
}