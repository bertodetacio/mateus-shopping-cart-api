package br.com.mateus.shoppingcart.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
@AllArgsConstructor
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "users")
@PrimaryKeyJoinColumn(name = "user_id")
public abstract class User extends Person {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Password cannot be null or blank")
	@Column(name = "password", nullable = true, unique = true)
	private String password;

	@Builder.Default
	@Column(name = "account_non_expired")
	private boolean accountNonExpired = false;

	@Builder.Default
	@Column(name = "account_non_locked")
	private boolean accountNonLocked = false;

	@Builder.Default
	@Column(name = "credentials_non_expired")
	private boolean credentialsNonExpired = false;

	@Builder.Default
	@Column(name = "enabled")
	private boolean enabled = false;

	//@Override
	/*
	 * public Collection<? extends GrantedAuthority> getAuthorities() { // TODO
	 * Auto-generated method stub return null; }
	 */

	//@Override
	public String getPassword() {
		return password;
	}

	//@Override
	public String getUsername() {
		return getEmail();
	}

	//@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	//@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	//@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	//@Override
	public boolean isEnabled() {
		return enabled;
	}

}
