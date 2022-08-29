package br.com.mateus.shoppingcart.api.v1.dtos.model.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Relation(collectionRelation = "storProductPkModel")
public class StoreProductPKModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    Long storeId;

    Long productId;
}
