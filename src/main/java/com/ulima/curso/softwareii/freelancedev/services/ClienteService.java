package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.dto.RegisterRequest;
import com.ulima.curso.softwareii.freelancedev.entities.users.Cliente;

import java.util.List;

public interface ClienteService extends UsuarioService<Cliente>{
  List<Cliente> findAll();
  Cliente save(Cliente cliente);
  Cliente registerCliente(RegisterRequest request);
  boolean existByNombre(String nombre);
}
