package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode (callSuper = true)
@Relation(collectionRelation = "customerCompanies")
public class CustomerCompanyModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotNull(message = "Position cannot be null or blank")
	private OccupationModel occupation;
	
	@NotNull(message = "Company cannot be null or blank")
	private CustomerCompanyModel customerCompany;
}
