package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "nfces")
public class NfceModel extends FiscalDocumentModel {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Positive
	private Long model;
	
	@NotNull
	@Positive
	@Column(name = "serie", nullable = true)
	private Long serie;
	
	@EqualsAndHashCode.Include
	@NotNull
	@Positive
	@Column(name = "number", nullable = true)
	private Long number;;
	
	@NotNull
	private Instant issueTimestamp;
	

	private Instant arrivalDepartureTimestamp;
	
	
	@NotNull
	private BigDecimal totalInvoiceAmount = new BigDecimal(0.00);
	
	@OneToOne (mappedBy = "nfce")
	private DanfeModel danfe;
	

}
