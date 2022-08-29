package br.com.mateus.shoppingcart.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode (callSuper = true, onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "states")
public class State extends BaseEntity{
	
	@EqualsAndHashCode.Include
	@NotBlank(message = "Name cannot be null or blank")
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@EqualsAndHashCode.Include
	@NotBlank(message = "Name cannot be null or blank")
	@Column(name = "acronym", nullable = false, unique = true)
	private String acronym;
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "state", cascade = CascadeType.ALL)
	private final List<City> cities = new ArrayList<City>();
	

}
