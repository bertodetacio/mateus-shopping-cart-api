package br.com.mateus.shoppingcart.api.v1.dtos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode (callSuper = true)
@Relation(collectionRelation = "occupations")
public class OccupationModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@NotBlank(message = "Position Description cannot be null or blanck")
	private String description;
	
	@NotNull (message = "Representative Legal List cannot be null")
	private final List<LegalRepresentativeModel> legalRepresentativeList = new ArrayList<LegalRepresentativeModel>();
}
