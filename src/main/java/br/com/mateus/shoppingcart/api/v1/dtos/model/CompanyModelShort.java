package br.com.mateus.shoppingcart.api.v1.dtos.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;
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
@Relation(collectionRelation = "companies")
public class CompanyModelShort extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@NotBlank(message = "Corporate Name cannot be null or blank")
	private String legallName;

	@NonNull
	@NotBlank(message = "Fantasy Name cannot be null or blank")
	@Column(name = "fantasy_name", nullable = false, length = 50)
	private String fantasyName;

	@NonNull
	@EqualsAndHashCode.Include
	@CNPJ
	@NotBlank(message = "CNPJ cannot be null or blank")
	private String cnpj;

}
