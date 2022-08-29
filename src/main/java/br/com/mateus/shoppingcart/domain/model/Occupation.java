package br.com.mateus.shoppingcart.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString (callSuper = true)
@Entity
@Table(name = "occupations")
public class Occupation extends BaseEntity{
	
	@EqualsAndHashCode.Include
	@NotBlank(message = "Position Description cannot be null or blanck")
	@Column(name = "description", nullable = false)
	private String description;
	
	@NotNull (message = "Representative Legal List cannot be null")
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "occupation")
	private final List<LegalRepresentative> legalRepresentativeList = new ArrayList<LegalRepresentative>(); 
}
