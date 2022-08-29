package br.com.mateus.shoppingcart.api.v1.dtos.model;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
@Relation(collectionRelation = "danfes")
public class DanfeModelShort extends FiscalDocumentModelShort{
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank (message = "Accesses key cannot be null or blank")
	private String accessKey;;
	
	@Positive
	@NonNull
	@NotNull
	private Long number;;
		
	@NotNull
	@NonNull
	@Positive
	private Double xmlVersion = 4.0;
	
	@NotNull
	@NotNull
	private NfceModelShort nfce;
	
	@NotNull
	@OneToOne
	private OrderModelShort order;
	
	@NotNull
	private CustomerModelShort customer;
	
	
	

}
