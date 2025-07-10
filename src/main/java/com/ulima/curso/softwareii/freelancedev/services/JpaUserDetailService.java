package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.entities.users.User;
import com.ulima.curso.softwareii.freelancedev.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JpaUserDetailService implements UserDetailsService {
  private final UserRepository userRepository;

  public JpaUserDetailService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<User> user_opt = userRepository.findByEmail(email);
    //Usuario u = new Usuario()
    if (user_opt.isPresent()) {
      User user = user_opt.get();

      Collection<GrantedAuthority> authorities = user.getRoles().stream()
          .map(rol -> new SimpleGrantedAuthority(rol.getRoleName()))
          .collect(Collectors.toList());

      return org.springframework.security.core.userdetails.User.builder()
          .username(user.getName())
          .password(user.getHashedPassword())
          .authorities(authorities)
          .disabled(false)
          .build();
    } else {
      throw new UsernameNotFoundException("User not found " + email);
    }
  }
}
