package com.ulima.curso.softwareii.freelancedev.repositories;

import com.ulima.curso.softwareii.freelancedev.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(exported = false)
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
  boolean existsByNombre(String nombre);
  boolean existsByCorreo(String correo);
  Optional<Cliente> findByCorreoOrNombre(String correo, String nombre);
}
