package br.com.mateus.shoppingcart.api.v1.dtos.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
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
@Relation(collectionRelation = "persons")
public class PersonModelShort extends BaseModel  {
	
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@NotNull (message = "First name cannot be null or blank")
	private String firstName;
	
	private String middleName;
	
	@NonNull
	@NotBlank(message = "Last Name cannot be null or blank")
	private String lastName;

	@EqualsAndHashCode.Include
	@NonNull
	@NotBlank(message = "CPF cannot be null or blank")
	@CPF (message = "CPF must be valid")
	private String cpf;
	
}
