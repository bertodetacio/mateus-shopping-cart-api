package br.com.mateus.shoppingcart.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cities")
public class City extends BaseEntity {

	@EqualsAndHashCode.Include
	@NotBlank(message = "Name cannot be null or blank")
	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@NotNull(message = "State cannot to be null")
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "state_id", nullable = false)
	private State state;

	@Builder.Default
	@NotNull(message = "Addresses Set cannot to be null")
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "city", cascade = CascadeType.ALL)
	private final Set<Address> addressesSet = new HashSet<Address>();

}
