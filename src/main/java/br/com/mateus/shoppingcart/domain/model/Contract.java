package br.com.mateus.shoppingcart.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString (callSuper = true)
@Entity
@Table(name = "contracts")
public class Contract extends BaseEntity {
	
	@Builder.Default
	@Column(name = "agree_terms_of_use", nullable = false)
	private boolean agreeTermsOfUse = false;

	@Builder.Default
	@Column(name = "agree_privacy_policy", nullable = false)
	private boolean agreePrivacyPolicy = false;

	@Builder.Default
	@Column(name = "notify_promotions_by_email", nullable = false)
	private boolean notifyPromotionsByEmail = false;

	@Builder.Default
	@Column(name = "notify_promotions_by_sms", nullable = false)
	private boolean notifyPromotionsBySms = false;

	@Builder.Default
	@Column(name = "notify_order_status_by_whatsapp", nullable = false)
	private boolean notifyOrderStatusByWhatsapp = false;
	
	@NotNull (message = "Constumer cannot be null")
	@OneToOne (fetch = FetchType.EAGER, mappedBy = "contract")
	private Customer customer;

}
