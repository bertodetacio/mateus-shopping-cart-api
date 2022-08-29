package br.com.mateus.shoppingcart.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_companies")
@PrimaryKeyJoinColumn(name = "customer_company_id")
public class CustomerCompany extends Company {
	
	@NotNull(message = "Core Business cannot be null")
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "core_business_id", nullable = false)
	private CoreBusiness coreBusiness;
	
	@NotNull(message = "Business Customer cannot be null")
	@OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn (name = "legal_representative_id")
	private LegalRepresentative legalRepresentative;

}
