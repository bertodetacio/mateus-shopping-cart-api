package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode (callSuper = true)
@Relation(collectionRelation = "departments")
public class DepartmentModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@NotNull(message = "Sections Set cannot be null")
	private Set<SectionModel> sectionsSet = new HashSet<SectionModel>();
	
	@NonNull
	@NotNull(message = "Stores Set cannot be null")
	private Set<StoreModel> storesSet = new HashSet<StoreModel>();

	
}
