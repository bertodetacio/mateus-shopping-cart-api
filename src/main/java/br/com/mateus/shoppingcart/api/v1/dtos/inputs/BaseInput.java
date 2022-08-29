package br.com.mateus.shoppingcart.api.v1.dtos.inputs;

import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseInput {

	@Schema(example = "1")
	@NotNull
	@NonNull
	private Long id;

	
}