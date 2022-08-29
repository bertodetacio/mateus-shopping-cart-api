package br.com.mateus.shoppingcart.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companies")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Company extends BaseEntity {

	@NotBlank(message = "Legal Name is mandatory")
	@Column(name = "legal_name", nullable = false, length = 50)
	private String legallName;

	@NotBlank(message = "Fantasy Name is mandatory")
	@Column(name = "fantasy_name", nullable = false, length = 50)
	private String fantasyName;

	@EqualsAndHashCode.Include
	@CNPJ
	@NotBlank(message = "CNPJ cannot be nul or blank")
	@Column(name = "cnpj", nullable = false, unique = true, length = 50)
	private String cnpj;

	@NotBlank(message = "Corporate Email must be valid")
	@Email(message = "Corporate Email must be valid")
	@Column(name = "corporate_mail", nullable = false)
	private String corporateEmail;

	@Pattern(regexp = "(\\([0-9]{2}\\)\\s?[0-9]{4,5}-?[0-9]{3,4})|([0-9]{10,11})|([0-9]{2}\\s?[0-9]{8,9})", message = "Non-standard input for corporate phone")
	@NotBlank(message = "Phone cannot be null or blank")
	@Column(name = "corporate_phone", length = 15, nullable = false, unique = false)
	private String corporatePhone;

	@Column(name = "state_registration", nullable = true, length = 50)
	private String stateRegistration;

	@Builder.Default
	@Column(name = "state_registration_exempt", nullable = false)
	private boolean stateRegistrationExempt = false;

	@NotNull(message = "Business Address cannot be null")
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "business_address_id")
	private BusinessAddress businessAddress;
	
}
