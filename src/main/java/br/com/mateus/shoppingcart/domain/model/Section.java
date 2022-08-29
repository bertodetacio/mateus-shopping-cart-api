package br.com.mateus.shoppingcart.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sections")
@PrimaryKeyJoinColumn(name = "section_id")
public class Section extends Sector {

	@NotNull(message = "Department cannot be null")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;
	
	@Builder.Default
	@NotNull
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "sections_products", joinColumns = @JoinColumn(name = "section_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private final Set<Product> productsSet = new HashSet<>();

}
