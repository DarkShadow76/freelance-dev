package com.ulima.curso.softwareii.freelancedev.repositories;

import com.ulima.curso.softwareii.freelancedev.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(exported = false)
public interface UsuarioRepository<T extends Usuario> extends JpaRepository<T, UUID> {
  boolean existsByNombre(String nombre);
  boolean existsByCorreo(String correo);
  Optional<T> findByNombre(String nombre);
  Optional<T> findByCorreo(String correo);
}
