package com.ulima.curso.softwareii.freelancedev.repositories;

import com.ulima.curso.softwareii.freelancedev.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(exported = false)
public interface UserRepository<T extends User> extends JpaRepository<T, UUID> {
  boolean existsByName(String name);
  boolean existsByEmail(String email);
  Optional<T> findByName(String name); // Only Recruiters can Search for Candidates
  Optional<T> findByEmail(String email);
}
