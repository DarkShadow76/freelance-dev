package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.entities.Usuario;
import com.ulima.curso.softwareii.freelancedev.repositories.RolRepository;
import com.ulima.curso.softwareii.freelancedev.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{
  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private RolRepository rolRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Usuario> findAll() {
    return (List<Usuario>) usuarioRepository.findAll();
  }

  @Override
  public Usuario save(Usuario usuario) {
    return null;
  }

  @Override
  public boolean existByNombre(String nombre) {
    return usuarioRepository.existsByNombre(nombre);
  }
}
