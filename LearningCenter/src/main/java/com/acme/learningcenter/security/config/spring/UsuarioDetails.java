package com.acme.learningcenter.security.config.spring;

import com.acme.learningcenter.security.domain.model.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Implementación de una clase detail que manipula al usuario
public class UsuarioDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// @Autowired
	private Usuario usuario;
	public UsuarioDetails(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		// Extraer la lista de las Authorities
		this.usuario.getAuthorities().forEach(authority -> {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
			grantedAuthorities.add(grantedAuthority);
		});

		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return this.usuario.getPassword();
	}

	@Override
	public String getUsername() {
		return this.usuario.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
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
		return this.usuario.isEnable();
	}
	
	// Datos de la Clase Usuario
	public String getNombres() {
		return this.usuario.getNombres();
	}
	public String getApellidos() {
		return this.usuario.getApellidos();
	}
	public String getCargo() {
		return this.usuario.getCargo();
	}

}
