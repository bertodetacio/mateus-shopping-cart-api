package br.com.mateus.shoppingcart.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

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
@Table(name = "addresses")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Address extends BaseEntity {

	@NonNull
	@NotBlank(message = "CEP cannot be null or blank")
	@Pattern(regexp = "[0-9]{5}-[0-9]{3}", message = "Invalid CEP")
	@Column(name = "cep", nullable = false)
	private String cep;
	
	@NonNull
	@NotBlank(message = "Street cannot be null or blank")
	@Column(name = "street", nullable = false)
    private String street;
	
	@NonNull
	@NotBlank(message = "District cannot be null or blank")
	@Column(name = "district", nullable = false)
    private String district;
	
	@NonNull
	@Positive (message = "House Number must be positive")
	@Column(name = "house_number", nullable = false)
    private Integer houseNumber;
	
	@Column(name = "complement", nullable = true)
    private String complement;
	
	@NonNull
	@NotNull(message = "City cannot be null")
	@ManyToOne
	@JoinColumn(name="city_id", nullable=false)
	private City city;
	

}
