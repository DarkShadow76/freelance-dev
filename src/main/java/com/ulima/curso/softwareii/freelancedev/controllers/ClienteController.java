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

import com.ulima.curso.softwareii.freelancedev.dto.response.ClientResponse;
import com.ulima.curso.softwareii.freelancedev.mappers.ClientMapper;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ver1/client")
public class ClienteController {
  private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

  private final ClienteService clienteService;

  public ClienteController(ClienteService clienteService) {
    this.clienteService = clienteService;
  }

  @GetMapping
  public ResponseEntity<List<ClientResponse>> getAllClientes() {
    List<Client> clientes = clienteService.findAll();
    List<ClientResponse> clientResponses = clientes.stream()
        .map(ClientMapper::toResponse)
        .collect(Collectors.toList());
    return ResponseEntity.ok(clientResponses);
  }

  @PostMapping("/register") // Esto mapeará a /api/ver1/cliente/register
  public ResponseEntity<ClientResponse> registerCliente(@RequestBody RegisterRequest registerRequest) {
    if (registerRequest == null || registerRequest.getName() == null || registerRequest.getEmail() == null || registerRequest.getPassword() == null) {
      return ResponseEntity.badRequest().build();
    }

    try {
      Client newCliente = clienteService.registerClient(registerRequest);
      return ResponseEntity.status(HttpStatus.CREATED).body(ClientMapper.toResponse(newCliente));
    } catch (RuntimeException e) {
      logger.error("Unexpected Error at register cliente: {}", e.getMessage(), e); // <-- ¡AQUÍ LOGUEAMOS EL STACK TRACE COMPLETO!
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }
}
