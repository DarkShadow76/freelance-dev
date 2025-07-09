package com.ulima.curso.softwareii.freelancedev.controllers;

import com.ulima.curso.softwareii.freelancedev.dto.request.RegisterRequest;
import com.ulima.curso.softwareii.freelancedev.entities.users.Client;
import com.ulima.curso.softwareii.freelancedev.services.ClienteService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

@RestController
@RequestMapping("/api/ver1/client")
public class ClienteController extends UsuarioController<Client>{
  private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

  private final ClienteService clienteService;

  public ClienteController(ClienteService clienteService) {
    super(clienteService);
    this.clienteService = clienteService;
  }

  @PostMapping("/register") // Esto mapeará a /api/ver1/cliente/register
  public ResponseEntity<?> registerCliente(@RequestBody RegisterRequest registerRequest) {
    if (registerRequest == null || registerRequest.getName() == null || registerRequest.getEmail() == null || registerRequest.getContrasenia() == null) {
      return ResponseEntity.badRequest().body("Incomplete Data for register.");
    }

    try {
      Client newCliente = clienteService.registerClient(registerRequest);

      return ResponseEntity.status(HttpStatus.CREATED).body("Client '" + newCliente.getEmail() + "' successfully registered.");
    } catch (RuntimeException e) {
      logger.error("Unexpected Error at register cliente: {}", e.getMessage(), e); // <-- ¡AQUÍ LOGUEAMOS EL STACK TRACE COMPLETO!
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
