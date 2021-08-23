package io.javabrains.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetail implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5392424790894231786L;

	private String username;

	private String password;

	private boolean active;

	private List< GrantedAuthority > authorities;

	public MyUserDetail( User user ) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.authorities = Arrays.stream( user.getRoles().split( "," ) )
				.map( SimpleGrantedAuthority::new )
				.collect( Collectors.toList() );
	}

	@Override
	public Collection< ? extends GrantedAuthority > getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.active;
	}

}
