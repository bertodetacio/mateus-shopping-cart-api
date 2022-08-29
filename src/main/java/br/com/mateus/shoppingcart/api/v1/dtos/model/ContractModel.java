package br.com.mateus.shoppingcart.api.v1.dtos.model;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "contracts")
public class ContractModel extends BaseModel {
	
	private static final long serialVersionUID = 1L;

	private boolean agreeTermsOfUse = false;

	private boolean agreePrivacyPolicy = false;

	private boolean notifyPromotionsByEmail = false;

	private boolean notifyPromotionsBySms = false;

	private boolean notifyOrderStatusByWhatsapp = false;
	
	@NotNull (message = "Constumer cannot be null")
	private CustomerModel customer;

}
