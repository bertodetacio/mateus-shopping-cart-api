package br.com.mateus.shoppingcart.domain.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode (callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StoreProductPK implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "store_id")
    Long storeId;

    @Column(name = "product_id")
    Long productId;

}