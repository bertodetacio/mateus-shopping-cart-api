package br.com.mateus.shoppingcart.api.v1.dtos.model;

import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode (callSuper = true)
@NoArgsConstructor
@Relation(collectionRelation = "users")
public class UserModel extends PersonModelShort  {
	
	private static final long serialVersionUID = 1L;
	
	private boolean accountNonExpired = false;

	private boolean accountNonLocked = false;

	private boolean credentialsNonExpired = false;

	private boolean enabled = false;
	
}
