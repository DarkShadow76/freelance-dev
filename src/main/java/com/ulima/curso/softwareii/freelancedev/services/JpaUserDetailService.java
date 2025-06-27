package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.entities.Usuario;
import com.ulima.curso.softwareii.freelancedev.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JpaUserDetailService implements UserDetailsService {
  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
    Optional<Usuario> user_opt = usuarioRepository.findByCorreo(correo);
    //Usuario u = new Usuario()
    if (user_opt.isPresent()) {
      Usuario usuario = user_opt.get();

      Collection<GrantedAuthority> authorities = usuario.getRoles().stream()
          .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
          .collect(Collectors.toList());

      return User.builder()
          .username(usuario.getNombre())
          .password(usuario.getContrasenia())
          .authorities(authorities)
          .disabled(false)
          .build();
    } else {
      throw new UsernameNotFoundException("Usuario no encontrado: " + correo);
    }
  }
}
