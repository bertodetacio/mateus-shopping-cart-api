package br.com.mateus.shoppingcart.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
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
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "legal_representatives")
@PrimaryKeyJoinColumn(name = "legal_representatives_id")
public class LegalRepresentative extends Customer {
	
	private static final long serialVersionUID = 1L;

	@NotNull(message = "Position cannot be null or blank")
	@ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn (name = "occupation_id")
	private Occupation occupation;
	
	@NotNull(message = "Company cannot be null or blank")
	@OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "legalRepresentative")
	private CustomerCompany customerCompany;

}
