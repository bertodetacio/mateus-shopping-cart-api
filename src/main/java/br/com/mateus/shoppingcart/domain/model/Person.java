package br.com.mateus.shoppingcart.domain.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString (callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person extends BaseEntity {
	
	@NonNull
	@NotNull (message = "First name cannot be null or blank")
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "middle_name", nullable = true)
	private String middleName;
	
	@NonNull
	@NotBlank(message = "Last Name cannot be null or blank")
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@NonNull
	@Pattern(regexp = "(\\([0-9]{2}\\)\\s?[0-9]{4,5}-?[0-9]{3,4})|([0-9]{10,11})|([0-9]{2}\\s?[0-9]{8,9})", message = "Non-standard input")
	@NotBlank(message = "Phone cannot be null or blank")
	@Column(name = "phone", length = 15, nullable = false, unique = false)
	private String phone;

	@EqualsAndHashCode.Include
	@NonNull
	@NotBlank(message = "Email cannot be null or blank")
	@Email (message = "Email must be valid")
	@Column(name = "email", nullable = true, unique = true)
	private String email;
	
	@EqualsAndHashCode.Include
	@NonNull
	@NotBlank(message = "CPF cannot be null or blank")
	@CPF (message = "CPF must be valid")
	@Column(name = "cpf", nullable = false, length = 14)
	private String cpf;
	
	@Column(name = "date_of_birth ", nullable = true)
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
