package br.com.mateus.shoppingcart.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
@ToString (callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brandings")
public class Branding extends BaseEntity { 
		
	@NotBlank (message = "Name cannot be null or blank")
	@EqualsAndHashCode.Include
	@Column(name = "name", nullable = false, length = 50)
	private String description;
		
	@NotNull(message = "Branding Set Set cannot be null")
	@OneToMany(mappedBy ="branding", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private final Set<Product> productsSet = new HashSet<Product>();

}
