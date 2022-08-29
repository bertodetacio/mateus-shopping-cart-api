package br.com.mateus.shoppingcart.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

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
@Table(name = "food_cards")
@PrimaryKeyJoinColumn(name = "food_card_id")
public class FoodCard extends Card {
	
	@Pattern(regexp =  "^[0-9]{3,4}$", message = "Invalid card expiration time")
	@Column(name = "cvv", nullable = true, length = 4)
	private String cvv;
	
}
