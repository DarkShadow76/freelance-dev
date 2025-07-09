package com.ulima.curso.softwareii.freelancedev.repositories;

import com.ulima.curso.softwareii.freelancedev.entities.users.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(exported = false)
public interface RolRepository extends JpaRepository<Rol, UUID> {
  Optional<Rol> findByNombre(String nombre);
}
