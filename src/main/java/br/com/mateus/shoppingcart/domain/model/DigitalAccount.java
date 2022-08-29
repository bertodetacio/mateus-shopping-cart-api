package br.com.mateus.shoppingcart.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "digital_account")
@PrimaryKeyJoinColumn(name = "digital_account_id")
public class DigitalAccount extends BaseEntity {

	@Default
	@NotNull
	@PositiveOrZero (message = "Balance must to positive or zero")
	@Column(name = "balance", nullable = false, length = 10)
	private BigDecimal balance = new BigDecimal(0.00);
	
	@NotNull
	@NotNull (message = "Customer Account cannot be null")
	@OneToOne (mappedBy = "digitalAccount")
	private Customer customer;

	public synchronized void deposit(BigDecimal amount) {
		balance = balance.add(amount);
	}

	public synchronized void debit(BigDecimal amount) {
		balance = balance.subtract(amount);
	}
	
	

}
