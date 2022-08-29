package br.com.mateus.shoppingcart.api.v1.dtos.model;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class CompanyModel extends BaseModel {
	
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

	@NonNull
	@NotBlank(message = "Corporate Email must be valid")
	@Email(message = "Corporate Email must be valid")
	private String corporateEmail;

	@NonNull
	@Pattern(regexp = "(\\([0-9]{2}\\)\\s?[0-9]{4,5}-?[0-9]{3,4})|([0-9]{10,11})|([0-9]{2}\\s?[0-9]{8,9})", message = "Non-standard input for corporate phone")
	@NotBlank(message = "Phone cannot be null or blank")
	@Column(name = "corporate_phone", length = 15, nullable = false, unique = false)
	private String corporatePhone;

	private String stateRegistration;

	private boolean stateRegistrationExempt = false;

	@NotNull(message = "Business Address cannot be null")
	private BusinessAddressModelShort businessAddress;


}
