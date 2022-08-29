package br.com.mateus.shoppingcart.domain.model;

import javax.persistence.Entity;
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
@EqualsAndHashCode(callSuper = true)
@ToString (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "business_addresses")
@PrimaryKeyJoinColumn(name = "business_address_id")
public class BusinessAddress extends Address{
	
	@NotNull (message = "Company cannot be null")
	@OneToOne (mappedBy = "businessAddress")
	private Company company;

}
