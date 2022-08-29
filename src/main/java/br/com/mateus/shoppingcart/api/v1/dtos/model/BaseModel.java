package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "bases")
public class BaseModel extends RepresentationModel<BaseModel> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Schema(example = "1")
	private Long id;

	

}
