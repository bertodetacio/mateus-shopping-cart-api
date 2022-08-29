package br.com.mateus.shoppingcart.api.v1.dtos.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "cities")
public class CityModelShort extends BaseModelShort {
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@NotBlank(message = "Name cannot be null or blank")
	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@NotNull(message = "State cannot to be null")
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "state_id", nullable = false)
	private StateModelShort state;
}
