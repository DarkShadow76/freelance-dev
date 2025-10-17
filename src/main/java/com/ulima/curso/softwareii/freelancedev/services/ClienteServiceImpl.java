package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.dto.request.RegisterRequest;
import com.ulima.curso.softwareii.freelancedev.entities.users.Client;
import com.ulima.curso.softwareii.freelancedev.repositories.ClientRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
  private final ClientRepository clientRepository;

  private final PasswordEncoder passwordEncoder;

  public ClienteServiceImpl(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
    this.clientRepository = clientRepository;
    this.passwordEncoder = passwordEncoder;
  }

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
    Nclient.setHashedPassword(passwordEncoder.encode(request.getPassword()));
    Nclient.setEnabled(true);

    return clientRepository.save(Nclient);
  }
}
