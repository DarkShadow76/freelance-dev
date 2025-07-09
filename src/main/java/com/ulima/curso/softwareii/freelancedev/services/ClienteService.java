package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.dto.RegisterRequest;
import com.ulima.curso.softwareii.freelancedev.entities.users.Client;

import java.util.List;

public interface ClienteService extends UserService<Client> {
  List<Client> findAll();
  Client save(Client cliente);
  Client registerClient(RegisterRequest request);
  boolean existByName(String name);
}
