package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
@Relation(collectionRelation = "coreBusinesses")
public class CoreBusinessModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@NotBlank(message = "Description cannot be null or blanck")
	@Column(name = "description", nullable = false)
	private String description;
	
	@NotNull (message = "Company Customer List cannot be null")
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "coreBusiness")
	private final Set<CustomerCompanyModel> customerCompanySet = new HashSet<CustomerCompanyModel>(); 

	
}
