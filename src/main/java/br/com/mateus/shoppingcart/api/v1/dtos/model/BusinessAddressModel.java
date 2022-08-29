package br.com.mateus.shoppingcart.api.v1.dtos.model;

import javax.persistence.OneToOne;
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
@Relation(collectionRelation = "bussinesAddresses")
public class BusinessAddressModel extends AddressModel  {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull (message = "Company cannot be null")
	@OneToOne (mappedBy = "businessAddress")
	private CompanyModel company;


}
