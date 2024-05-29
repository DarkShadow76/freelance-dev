package com.ulima.curso.softwareii.freelancedev.repositories;

import com.ulima.curso.softwareii.freelancedev.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(exported = false)
public interface UsuarioRepository<T extends Usuario> extends CrudRepository<T, UUID> {
  boolean existsByNombre(String nombre);
  Optional<T> findByNombre(String nombre);
}
