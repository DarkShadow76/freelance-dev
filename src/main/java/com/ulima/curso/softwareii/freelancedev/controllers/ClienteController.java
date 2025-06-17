package com.ulima.curso.softwareii.freelancedev.controllers;

import com.ulima.curso.softwareii.freelancedev.entities.Cliente;
import com.ulima.curso.softwareii.freelancedev.services.ClienteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ver1/cliente")
public class ClienteController extends UsuarioController<Cliente>{
  private final ClienteService clienteService;

  public ClienteController(ClienteService clienteService) {
    super(clienteService);
    this.clienteService = clienteService;
  }
}
