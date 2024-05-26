package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.entities.Cliente;
import com.ulima.curso.softwareii.freelancedev.repositories.ClienteRepository;
import com.ulima.curso.softwareii.freelancedev.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private RolRepository rolRepository;

  @Override
  public List<Cliente> findAll() {
    return null;
  }

  @Override
  public Cliente save(Cliente cliente) {
    return null;
  }

  @Override
  public boolean existByNombre(String nombre) {
    return false;
  }
}
