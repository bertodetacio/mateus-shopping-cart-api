package br.com.mateus.shoppingcart.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Table(name = "departments")
@PrimaryKeyJoinColumn(name = "department_id")
public class Department extends Sector {
	
	@NotNull(message = "Sections Set cannot be null")
	@OneToMany(mappedBy ="department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private final Set<Section> sectionsSet = new HashSet<Section>();
	
	@NotNull(message = "Stores Set cannot be null")
	@ManyToMany(mappedBy ="departmentsSet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private final Set<Store> storesSet = new HashSet<Store>();

}
