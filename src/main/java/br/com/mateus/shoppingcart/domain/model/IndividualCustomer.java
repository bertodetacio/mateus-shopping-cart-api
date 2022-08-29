package br.com.mateus.shoppingcart.domain.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@ToString (callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "individual_costumers")
@PrimaryKeyJoinColumn(name = "individual_costumers_id")
public class IndividualCustomer extends Customer{
	
	private static final long serialVersionUID = 1L;
	

}
