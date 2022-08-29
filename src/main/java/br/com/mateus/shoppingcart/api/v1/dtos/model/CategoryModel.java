package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@Relation(collectionRelation = "categories")
public class CategoryModel extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@NotBlank(message = "Stores Set cannot to be null or blank")
	private String name;
	
	@NonNull
	@NotNull(message = "Stores Set cannot to be null")
	private final Set<StoreModel> storesSet = new HashSet<StoreModel>();
	
}
