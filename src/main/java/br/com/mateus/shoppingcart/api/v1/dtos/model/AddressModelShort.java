package br.com.mateus.shoppingcart.api.v1.dtos.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

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
@Relation(collectionRelation = "addresses")
public class AddressModelShort extends BaseModelShort  {
	
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@NotBlank(message = "CEP cannot be null or blank")
	@Pattern(regexp = "[0-9]{5}-[0-9]{3}", message = "Invalid CEP")
	private String cep;
	
	@NonNull
	@NotBlank(message = "Street cannot be null or blank")
	private String street;
	
	@NonNull
	@NotBlank(message = "District cannot be null or blank")
	private String district;
	
	@NonNull
	@Positive (message = "House Number must be positive")
	private Integer houseNumber;
	
	@Column(name = "complement", nullable = true)
    private String complement;
	
	@NotNull(message = "City cannot be null or blank")
	private CityModelShort city;
	
	@NotNull(message = "State cannot be null or blank")
	private StateModelShort state;
	
	

}
