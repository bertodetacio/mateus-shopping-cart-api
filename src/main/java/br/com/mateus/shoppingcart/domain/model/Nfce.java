package br.com.mateus.shoppingcart.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode (callSuper = true, onlyExplicitlyIncluded = true)
@ToString (callSuper = true)
@Entity
@Table (name = "nfces")
@PrimaryKeyJoinColumn(name = "nfce_id")
public class Nfce extends FiscalDocument {
	
	@Default
	@NotNull
	@Positive
	@Column(name = "model", nullable = false)
	private Long model = Math.abs(UUID.randomUUID().getMostSignificantBits());
	
	@Default
	@NotNull
	@Positive
	@Column(name = "serie", nullable = false)
	private Long serie = Math.abs(UUID.randomUUID().getMostSignificantBits());
	
	@Default
	@EqualsAndHashCode.Include
	@NotNull
	@Positive
	@Column(name = "number", nullable = false)
	private Long number = Math.abs(UUID.randomUUID().getMostSignificantBits());
	
	@Default
	@NotNull
	@Column(name = "issue_timestamp", nullable = true)
	private Instant issueTimestamp = Instant.now();
	
	@Default
	@Column(name = "arrival_departure_timestamp", nullable = true)
	private Instant arrivalDepartureTimestamp = Instant.now();
	
	@Default
	@NotNull
	@Column(name = "total_invoice_amount", nullable = true, precision = 10)
	private BigDecimal totalInvoiceAmount = new BigDecimal(0.00);
	
	@OneToOne (mappedBy = "nfce")
	private Danfe danfe;
	
	@NotNull
	@OneToOne
	@JoinColumn (name = "order_id")
	private Order order;
	
	@NotNull
	@ManyToOne
	@JoinColumn (name = "customer_id")
	private Customer customer;
}
