package com.acme.learningcenter.security.domain.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 30, nullable = false)
    private String username;

    @Column(length = 60, nullable = false)
    private String password;

    private boolean enable;
    
    @Column(length = 40, nullable = false)
    private String apellidos;
    
    @Column(length = 40, nullable = false)
    private String nombres;
    
    @Column(length = 30, nullable = false)
    private String cargo;
    
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)    
    private List<Authority> authorities;

	public Usuario() {
		this.enable = true;
		this.authorities = new ArrayList<>();
	}
	public Usuario( String username, String password ) {
		this.username = username;
		this.password = password;
		this.enable = true;
		this.authorities = new ArrayList<>();
	}
	
	public void addAuthority( String _authority ) {
		Authority authority = new Authority();
		authority.setAuthority( _authority );
		authority.setUsuario(this);
		this.authorities.add(authority);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
    
    
}
