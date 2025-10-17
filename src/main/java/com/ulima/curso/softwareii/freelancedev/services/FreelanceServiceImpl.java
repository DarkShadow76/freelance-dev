package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.dto.request.RegisterRequest;
import com.ulima.curso.softwareii.freelancedev.entities.users.Freelancer;
import com.ulima.curso.softwareii.freelancedev.repositories.FreelancerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class FreelanceServiceImpl implements FreelancerService {
  private final FreelancerRepository freelancerRepository;

  private final PasswordEncoder passwordEncoder;

  public FreelanceServiceImpl(FreelancerRepository freelancerRepository, PasswordEncoder passwordEncoder) {
    this.freelancerRepository = freelancerRepository;
    this.passwordEncoder = passwordEncoder;
  }


  @Override
  @Transactional(readOnly = true)
  public List<Freelancer> findAll() {
    return freelancerRepository.findAll();
  }

  @Override
  @Transactional
  public Freelancer save(Freelancer freelancer) {
    return freelancerRepository.save(freelancer);
  }

  @Override
  public boolean existByName(String name) {
    return freelancerRepository.existsByName(name);
  }

  @Override
  @Transactional
  public Freelancer registerFreelancer(RegisterRequest request) {
    if (freelancerRepository.existsByEmail(request.getEmail())){
      throw new IllegalStateException("Candidate with email already Exist: "+ request.getEmail());
    }
    if (freelancerRepository.existsByName(request.getName())){
      throw new IllegalStateException("Candidate with username already Exist: "+ request.getName());
    }

    Freelancer NFreelancer = new Freelancer();
    NFreelancer.setName(request.getName());
    NFreelancer.setEmail(request.getEmail());

    NFreelancer.setHashedPassword(passwordEncoder.encode(request.getPassword()));
    NFreelancer.setEnabled(true);

    return freelancerRepository.save(NFreelancer);
  }
}
