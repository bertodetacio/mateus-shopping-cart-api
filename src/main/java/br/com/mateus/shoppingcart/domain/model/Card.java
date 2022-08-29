package br.com.mateus.shoppingcart.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cards")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Card extends PaymentObject {
	
	@NotBlank(message = "Name printed on Card cannot be null or blanck")
	@Column(name = "card_printed_name", nullable = false, length = 50)
	private String cardPrintedName;
	
	@NotBlank(message = "Credit Card Number cannot be null or blank")
	@CreditCardNumber (message = "the card number must be between 13 and 16 digits")
	@Column(name = "card_number", nullable = false, length = 16)
	private String cardNumber;
	
	@NotBlank(message = "Card Expiration Date cannot be null or blank")
	@Column(name = "card_expiration_date", nullable = true, length = 5)
	@Pattern(regexp =  "^(0[1-9]|1[0-2]|[1-9])\\/(1[4-9]|[2-9][0-9]|20[1-9][1-9])$", message = "Invalid card expiration time")
	private String cardExpirationDate;
	
	
	
	

}
