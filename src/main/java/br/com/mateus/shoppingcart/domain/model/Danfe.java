package br.com.mateus.shoppingcart.domain.model;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@Entity
@Table(name = "danfes")
@PrimaryKeyJoinColumn(name = "danf_id")
public class Danfe extends FiscalDocument {
	
	@Default
	@NotBlank (message = "Accesses key cannot be null or blank")
	@Column(name = "access_key", nullable = false)
	private String accessKey = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
	
	@Default
	@Positive
	@NonNull
	@NotNull
	@Column(name = "number", nullable = false)
	private Long number = Math.abs(UUID.randomUUID().getMostSignificantBits());
	
	@Default
	@NotNull
	@NonNull
	@Positive
	@Column(name = "xml_version", nullable = false)
	private Double xmlVersion = 4.0;
	
	@NotNull
	@NotNull
	@OneToOne
	@JoinColumn (name = "nfce_id")
	private Nfce nfce;
	
	@NotNull
	@OneToOne
	@JoinColumn (name = "order_id")
	private Order order;
	
	@NotNull
	@ManyToOne
	@JoinColumn (name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "danfe", fetch = FetchType.LAZY)
	private final Set<Item> itemsSet = new HashSet<Item>();
	

}
