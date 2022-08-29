package br.com.mateus.shoppingcart.domain.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Data
@EqualsAndHashCode (callSuper = true, onlyExplicitlyIncluded = true)
@ToString (callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class FiscalDocument extends BaseEntity {
	
}
