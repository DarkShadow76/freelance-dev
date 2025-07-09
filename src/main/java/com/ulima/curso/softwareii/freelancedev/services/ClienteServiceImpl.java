package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.dto.RegisterRequest;
import com.ulima.curso.softwareii.freelancedev.entities.users.Client;
import com.ulima.curso.softwareii.freelancedev.entities.users.Role;
import com.ulima.curso.softwareii.freelancedev.repositories.ClientRepository;
import com.ulima.curso.softwareii.freelancedev.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private RolRepository rolRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional(readOnly = true)
  public List<Client> findAll() {
    return clientRepository.findAll();
  }

  @Override
  @Transactional
  public Client save(Client cliente) {
    return clientRepository.save(cliente);
  }

  @Override
  public boolean existByName(String name) {
    return clientRepository.existsByName(name);
  }

  @Transactional
  public Client registerClient(RegisterRequest request) {
    if (clientRepository.existsByEmail(request.getEmail())){
      throw new IllegalStateException("User with email already Exist: "+ request.getEmail());
    }
    if (clientRepository.existsByName(request.getName())){
      throw new IllegalStateException("User with username already Exist: "+ request.getName());
    }

    Client Nclient = new Client();
    Nclient.setName(request.getName());
    Nclient.setEmail(request.getEmail());
    // Hash Password
    Nclient.setHashedPassword(passwordEncoder.encode(request.getContrasenia()));
    Nclient.setAdmin(false);
    Nclient.setEnabled(true);

    Role defaulRole = rolRepository.findByRoleName("ROLE_CLIENT")
        .orElseThrow(() -> new RuntimeException("Error: Role for Client Not found."));

    Nclient.setRoles(Collections.singletonList(defaulRole));

    return clientRepository.save(Nclient);
  }
}
