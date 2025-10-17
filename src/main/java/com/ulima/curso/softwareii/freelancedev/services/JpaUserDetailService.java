package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.entities.users.User;
import com.ulima.curso.softwareii.freelancedev.repositories.ClientRepository;
import com.ulima.curso.softwareii.freelancedev.repositories.FreelancerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaUserDetailService implements UserDetailsService {
  private final ClientRepository clientRepository;
  private final FreelancerRepository freelancerRepository;

  public JpaUserDetailService(ClientRepository clientRepository, FreelancerRepository freelancerRepository) {
    this.clientRepository = clientRepository;
    this.freelancerRepository = freelancerRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<User> user_opt = clientRepository.findByEmail(email).map(User.class::cast);
    if (user_opt.isEmpty()) {
      user_opt = freelancerRepository.findByEmail(email).map(User.class::cast);
    }

    if (user_opt.isPresent()) {
      User user = user_opt.get();

      return org.springframework.security.core.userdetails.User.builder()
          .username(user.getName())
          .password(user.getHashedPassword())
          .authorities(java.util.Collections.emptyList())
          .disabled(false)
          .build();
    } else {
      throw new UsernameNotFoundException("User not found " + email);
    }
  }
}
