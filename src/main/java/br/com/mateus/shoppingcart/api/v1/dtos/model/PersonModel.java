package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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
public class PersonModel extends BaseModel  {
	
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@NotNull (message = "First name cannot be null or blank")
	private String firstName;
	
	private String middleName;
	
	@NonNull
	@NotBlank(message = "Last Name cannot be null or blank")
	private String lastName;

	@NonNull
	@Pattern(regexp = "(\\([0-9]{2}\\)\\s?[0-9]{4,5}-?[0-9]{3,4})|([0-9]{10,11})|([0-9]{2}\\s?[0-9]{8,9})", message = "Non-standard input")
	@NotBlank(message = "Phone cannot be null or blank")
	private String phone;

	@EqualsAndHashCode.Include
	@NonNull
	@NotBlank(message = "Email cannot be null or blank")
	@Email (message = "Email must be valid")
	private String email;
	
	@EqualsAndHashCode.Include
	@NonNull
	@NotBlank(message = "CPF cannot be null or blank")
	@CPF (message = "CPF must be valid")
	private String cpf;
	
	@DateTimeFormat (iso = ISO.DATE)
	private LocalDate dateOfBirth;
	
	public String getFullName() {
		String fullName = null;
		if(firstName!=null && !firstName.isBlank()) {
			fullName =firstName+" ";
		}
		if(middleName!=null && !middleName.isBlank()) {
			fullName =middleName;
		}
		if(lastName!=null && !lastName.isBlank()) {
			fullName =lastName;
		}
		return fullName;
	}

}
