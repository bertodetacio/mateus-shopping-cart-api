package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.util.Set;

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
@Relation(collectionRelation = "sections")
public class SectionModel extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Department cannot be null")
	private DepartmentModel department;
	
	@NotNull
	private Set<ProductModel> productsSet;

	
}
