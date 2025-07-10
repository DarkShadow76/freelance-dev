package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.entities.users.Role;
import com.ulima.curso.softwareii.freelancedev.entities.users.User;
import com.ulima.curso.softwareii.freelancedev.repositories.RolRepository;
import com.ulima.curso.softwareii.freelancedev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl<T extends User> implements UserService<T> {
  private final UserRepository<T> userRepository;

  private final RolRepository rolRepository;

  private final PasswordEncoder passwordEncoder;

  public UserServiceImpl(UserRepository<T> userRepository, RolRepository rolRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.rolRepository = rolRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  @Transactional(readOnly = true)
  public List<T> findAll() {
    return userRepository.findAll();
  }

  @Override
  @Transactional
  public T save(T user) {
    Optional<Role> optionalRolUser = rolRepository.findByRoleName("ROLE_USER");
    List<Role> roles = new ArrayList<>();

    optionalRolUser.ifPresent(roles::add);

    if (user.isAdmin()) {
      Optional<Role> optionalRolAdmin = rolRepository.findByRoleName("ROLE_ADMIN");
      optionalRolAdmin.ifPresent(roles::add);
    }

    user.setRoles(roles);

    if (passwordEncoder != null && isPasswordAlreadyEncoded(user.getHashedPassword())) {
      user.setHashedPassword(passwordEncoder.encode(user.getHashedPassword()));
    } else {
      user.setHashedPassword(user.getHashedPassword());
    }

    return userRepository.save(user);
  }

  @Override
  @Transactional
  public boolean existByName(String name) {
    return userRepository.existsByName(name);
  }

  private boolean isPasswordAlreadyEncoded(String password) {
    return password != null && password.startsWith("$2a$") || password.startsWith("$2b$") || password.startsWith("$2y$");
  }
}
