package br.com.mateus.shoppingcart.api.v1.dtos.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode (callSuper = true)
@Relation(collectionRelation = "sectors")
public class SectorModelShort extends BaseModelShort  {
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@NotBlank (message = "Name cannot be null or blank")
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@EqualsAndHashCode.Include
	@NotNull (message = "Code cannot be null or blank")
	@Positive
	@Column(name = "code", nullable = false, length = 50)
	private Long code;
}
