package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.dto.RegisterRequest;
import com.ulima.curso.softwareii.freelancedev.entities.users.Freelancer;
import com.ulima.curso.softwareii.freelancedev.entities.users.Role;
import com.ulima.curso.softwareii.freelancedev.repositories.FreelancerRepository;
import com.ulima.curso.softwareii.freelancedev.repositories.RolRepository;
import com.ulima.curso.softwareii.freelancedev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class FreelanceServiceImpl implements FreelancerService {
  @Autowired
  private FreelancerRepository freelancerRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RolRepository rolRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public List<Freelancer> findAll() {
    return null;
  }

  @Override
  public Freelancer save(Freelancer freelancer) {
    return null;
  }

  @Override
  public boolean existByName(String name) {
    return false;
  }

  @Override
  @Transactional
  public Freelancer registerFreelancer(RegisterRequest request) {
    if (userRepository.existsByEmail(request.getEmail())){
      throw new IllegalStateException("User with email already Exist: "+ request.getEmail());
    }
    if (userRepository.existsByName(request.getName())){
      throw new IllegalStateException("User with username already Exist: "+ request.getName());
    }

    Freelancer NFreelancer = new Freelancer();
    NFreelancer.setName(request.getName());
    NFreelancer.setEmail(request.getEmail());

    NFreelancer.setHashedPassword(passwordEncoder.encode(request.getContrasenia()));
    NFreelancer.setAdmin(false);
    NFreelancer.setEnabled(true);

    Role defaulRole = rolRepository.findByRoleName("ROLE_FREELANCER")
        .orElseThrow(() -> new RuntimeException("Error: Role for Freelancer Not found."));

    NFreelancer.setRoles(Collections.singletonList(defaulRole));

    return freelancerRepository.save(NFreelancer);
  }
}
