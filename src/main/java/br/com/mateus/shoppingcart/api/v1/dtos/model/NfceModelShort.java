package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.math.BigDecimal;
import java.time.Instant;

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
public class NfceModelShort extends FiscalDocumentModelShort {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Positive
	private Long model;
	
	@NotNull
	@Positive
	private Long serie;
	
	@EqualsAndHashCode.Include
	@NotNull
	@Positive
	private Long number;;
	
	@NotNull
	private Instant issueTimestamp;
	
	private Instant arrivalDepartureTimestamp;
		
	@NotNull
	private BigDecimal totalInvoiceAmount = new BigDecimal(0.00);
	
	private DanfeModelShort danfe;
	

}
