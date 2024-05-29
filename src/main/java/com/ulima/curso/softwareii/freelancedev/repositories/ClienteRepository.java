package com.ulima.curso.softwareii.freelancedev.repositories;

import com.ulima.curso.softwareii.freelancedev.entities.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(exported = false)
public interface ClienteRepository extends CrudRepository<Cliente, UUID> {
  boolean existsByNombre(String nombre);
  Optional<Cliente> findByNombre(String nombre);
}
