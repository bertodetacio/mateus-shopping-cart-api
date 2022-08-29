package br.com.mateus.shoppingcart.domain.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString (callSuper = true)
@AllArgsConstructor
@Entity
@Table(name = "credit_cards")
@PrimaryKeyJoinColumn(name = "credit_card_id")
public class CreditCard extends Card {}
