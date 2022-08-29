package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

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
@Relation(collectionRelation = "brandings")
public class BrandingModelShort extends BaseModelShort implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@NotBlank (message = "Name cannot be null or blank")
	@EqualsAndHashCode.Include
	private String description;
	
	
	
}
