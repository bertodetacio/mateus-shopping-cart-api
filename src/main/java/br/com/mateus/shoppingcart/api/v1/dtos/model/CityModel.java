package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "cities")
public class CityModel extends BaseModelShort {
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@NotBlank(message = "Name cannot be null or blank")
	private String name;

	@NotNull(message = "State cannot to be null")
	private StateModel state;
}
