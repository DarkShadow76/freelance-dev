package com.ulima.curso.softwareii.freelancedev.repositories;

import com.ulima.curso.softwareii.freelancedev.entities.users.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(exported = false)
public interface ClientRepository extends JpaRepository<Client, UUID> {
  boolean existsByName(String name);
  boolean existsByEmail(String email);
}
