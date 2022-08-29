package br.com.mateus.shoppingcart.api.v1.dtos.inputs;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode (callSuper = true)
public class PaymentObjectInput extends BaseInput {
	
	@Schema (example = "1234")
	@Pattern(regexp = "^[0-9]{3,4}$", message = "Invalid card expiration time")
	@Column(name = "cvv", nullable = true, length = 4)
	private String cvv;
	
	@Schema (example = "1")
	@NotNull
	@NotNull
	private Integer installmentsNumber;
	
}