package com.ulima.curso.softwareii.freelancedev.repositories;

import com.ulima.curso.softwareii.freelancedev.entities.users.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(exported = false)
public interface FreelancerRepository extends JpaRepository<Freelancer, UUID> {
  boolean existsByName(String name);
  boolean existsByEmail(String email);
  Optional<Freelancer> findByEmail(String email);
  Optional<Freelancer> findByName(String name);
}
