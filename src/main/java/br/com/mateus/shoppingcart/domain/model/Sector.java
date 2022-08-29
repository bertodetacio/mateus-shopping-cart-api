package br.com.mateus.shoppingcart.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sectors")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Sector extends BaseEntity {
	
	@EqualsAndHashCode.Include
	@NotBlank (message = "Name cannot be null or blank")
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@EqualsAndHashCode.Include
	@NotNull (message = "Code cannot be null or blank")
	@Positive
	@Column(name = "code", nullable = false, length = 50)
	private Long code;

}
