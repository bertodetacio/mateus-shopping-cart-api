package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (callSuper = true)
@Relation(collectionRelation = "departments")
public class DepartmentModelShort extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@NotNull(message = "Sections Set cannot be null")
	private Set<SectionModelShort> sectionsSet;
	
	@NonNull
	@NotNull(message = "Stores Set cannot be null")
	private Set<StoreModelShort> storesSet;

	
}
