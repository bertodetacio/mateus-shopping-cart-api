package br.com.mateus.shoppingcart.api.v1.dtos.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@EqualsAndHashCode (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "items")
public class CardModelShort extends PaymentObjectModelShort {
	
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@NotBlank(message = "Name printed on Card cannot be null or blanck")
	private String cardPrintedName;
	
	@NonNull
	@NotBlank(message = "Credit Card Number cannot be null or blank")
	@CreditCardNumber (message = "the card number must be between 13 and 16 digits")
	private String cardNumber;
	
	@NonNull
	@NotBlank(message = "Card Expiration Date cannot be null or blank")
	@Column(name = "card_expiration_date", nullable = true, length = 5)
	@Pattern(regexp =  "^(0[1-9]|1[0-2]|[1-9])\\/(1[4-9]|[2-9][0-9]|20[1-9][1-9])$", message = "Invalid card expiration time")
	private String cardExpirationDate;
	

	
}
