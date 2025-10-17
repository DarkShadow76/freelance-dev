package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.dto.request.RegisterRequest;
import com.ulima.curso.softwareii.freelancedev.entities.users.Client;

import java.util.List;

public interface ClienteService {
  List<Client> findAll();
  Client save(Client cliente);
  Client registerClient(RegisterRequest request);
  boolean existByName(String name);
}
