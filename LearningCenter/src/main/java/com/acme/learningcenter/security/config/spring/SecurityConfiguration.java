package com.acme.learningcenter.security.config.spring;

import com.acme.learningcenter.security.config.jwt.JwtAuthenticationFilter;
import com.acme.learningcenter.security.config.jwt.JwtAuthorizationFilter;
import com.acme.learningcenter.security.domain.persistence.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioDetailsService usuarioDetailsService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Bean
	PasswordEncoder passwordEncoder( ) {
		return new BCryptPasswordEncoder();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.usuarioDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

		return daoAuthenticationProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	        // remove csrf and state in session because in jwt we do not need them
	        .csrf().disable()
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        .and()
	        // add jwt filters (1. authentication, 2. authorization)
	        .addFilter(new JwtAuthenticationFilter(authenticationManager()))
	        .addFilter(new JwtAuthorizationFilter(authenticationManager(),  this.usuarioRepository))
	        .authorizeRequests()
	        // configure access rules
	        //antMatchers(HttpMethod.POST, "/loginrest").permitAll()
	        .antMatchers("/api/v1/posts").hasRole("STUDENT")
					.antMatchers("/api/v1/posts/**").hasAnyRole("TEACHER", "STUDENT")
	        .anyRequest().authenticated();
	}
}
