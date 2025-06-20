package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.entities.Rol;
import com.ulima.curso.softwareii.freelancedev.entities.Usuario;
import com.ulima.curso.softwareii.freelancedev.repositories.RolRepository;
import com.ulima.curso.softwareii.freelancedev.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl<T extends Usuario> implements UsuarioService<T> {
  @Autowired
  private UsuarioRepository<T> usuarioRepository;

  @Autowired
  private RolRepository rolRepository;

  @Autowired(required = false)
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional(readOnly = true)
  public List<T> findAll() {
    return (List<T>) usuarioRepository.findAll();
  }

  @Override
  @Transactional
  public T save(T usuario) {
    Optional<Rol> optionalRolUsuario = rolRepository.findByNombre("ROLE_USER");
    List<Rol> roles = new ArrayList<>();

    optionalRolUsuario.ifPresent(roles::add);

    if (usuario.isAdmin()) {
      Optional<Rol> optionalRolAdmin = rolRepository.findByNombre("ROLE_ADMIN");
      optionalRolAdmin.ifPresent(roles::add);
    }

    usuario.setRoles(roles);

    if (passwordEncoder != null && isPasswordAlreadyEncoded(usuario.getContrasenia())) {
      usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
    } else {
      usuario.setContrasenia(usuario.getContrasenia());
    }

    return usuarioRepository.save(usuario);
  }

  @Override
  @Transactional
  public boolean existByNombre(String nombre) {
    return usuarioRepository.existsByNombre(nombre);
  }

  private boolean isPasswordAlreadyEncoded(String password) {
    return password != null && password.startsWith("$2a$") || password.startsWith("$2b$") || password.startsWith("$2y$");
  }
}
