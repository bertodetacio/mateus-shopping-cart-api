package br.com.mateus.shoppingcart.api.v1.dtos.model;

import javax.validation.constraints.NotBlank;

import org.springframework.hateoas.server.core.Relation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@EqualsAndHashCode (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "states")
public class StateModelShort extends BaseModelShort  {
	
	private static final long serialVersionUID = 1L;
	
	@Schema(example = "Maranhão")
	@NonNull
	@EqualsAndHashCode.Include
	@NotBlank(message = "Name cannot be null or blank")
	private String name;
	
	@Schema(example = "MA")
	@EqualsAndHashCode.Include
	@NonNull
	@NotBlank(message = "Acronym cannot be null or blank")
	private String acronym;
}
