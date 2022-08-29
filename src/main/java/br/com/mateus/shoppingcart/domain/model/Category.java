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

import org.springframework.lang.NonNull;

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
@Table(name = "categories")
public class Category extends BaseEntity {
	
	@NonNull
	@NotBlank(message = "Stores Set cannot to be null or blank")
	@Column(name = "name", nullable = false, unique =true)
	private String name;
	
	@Builder.Default
	@NotNull(message = "Stores Set cannot to be null")
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
	private final Set<Store> storesSet = new HashSet<Store>();

}
