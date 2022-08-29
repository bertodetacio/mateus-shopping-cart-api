package br.com.mateus.shoppingcart.domain.model;

import java.util.HashSet;
import java.util.Set;

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
@ToString (callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "core_businesses")
public class CoreBusiness extends BaseEntity{
	
	@EqualsAndHashCode.Include
	@NotBlank(message = "Description cannot be null or blanck")
	@Column(name = "description", nullable = false)
	private String description;
	
	@NotNull (message = "Company Customer List cannot be null")
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "coreBusiness")
	private final Set<CustomerCompany> customerCompanySet = new HashSet<CustomerCompany>(); 
}
