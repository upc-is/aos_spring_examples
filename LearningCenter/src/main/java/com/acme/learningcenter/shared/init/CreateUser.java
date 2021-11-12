package com.acme.learningcenter.shared.init;

import com.acme.learningcenter.security.domain.model.entity.Usuario;
import com.acme.learningcenter.security.domain.persistence.AuthorityRepository;
import com.acme.learningcenter.security.domain.persistence.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CreateUser implements CommandLineRunner {
  @Autowired
  private UsuarioRepository usuarioRepository;
  @Autowired
  private AuthorityRepository authorityRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) throws Exception {

    // SOLO DESBLOQUEAR CUANDO QUIERAS CREAR USUARIOS
    /*
    Usuario juan = new Usuario();
    juan.setUsername("juan");
    juan.setPassword(passwordEncoder.encode("juan"));
    juan.setEnable(true);
    juan.setApellidos("XXXX");
    juan.setNombres("YYYYY");
    juan.setCargo("Estudiante");

    juan.addAuthority("ROLE_STUDENT");
    juan.addAuthority("ACCESS_COMMENT");

    Usuario admin= new Usuario();
    admin.setUsername("antonio");
    admin.setPassword(passwordEncoder.encode("antonio"));
    admin.setEnable(true);
    admin.setApellidos("XXXX");
    admin.setNombres("YYYYY");
    admin.setCargo("Profesor");

    admin.addAuthority("ROLE_TEACHER");
    admin.addAuthority("ACCESS_COMMENT");
    admin.addAuthority("ACCESS_POSTS");


    List<Usuario> usuarios= Arrays.asList(juan, admin);
    this.usuarioRepository.saveAll(usuarios);
    */

  }
}
