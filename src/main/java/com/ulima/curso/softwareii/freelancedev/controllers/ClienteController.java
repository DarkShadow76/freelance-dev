package com.ulima.curso.softwareii.freelancedev.controllers;

import com.ulima.curso.softwareii.freelancedev.dto.RegisterRequest;
import com.ulima.curso.softwareii.freelancedev.entities.Cliente;
import com.ulima.curso.softwareii.freelancedev.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ver1/cliente")
public class ClienteController extends UsuarioController<Cliente>{
  private final ClienteService clienteService;

  @Autowired
  public ClienteController(ClienteService clienteService) {
    super(clienteService);
    this.clienteService = clienteService;
  }

  @PostMapping("/register") // Esto mapeará a /api/ver1/cliente/register
  public ResponseEntity<?> registerCliente(@RequestBody RegisterRequest registerRequest) {
    // Las validaciones básicas de campos nulos en RegisterRequest
    // pueden manejarse con @Valid en el DTO y @NotNull/@NotBlank,
    // pero una validación manual simple como esta es aceptable.
    if (registerRequest == null || registerRequest.getNombre() == null || registerRequest.getCorreo() == null || registerRequest.getContrasenia() == null) {
      return ResponseEntity.badRequest().body("Datos de registro incompletos.");
    }

    try {
      Cliente newCliente = clienteService.registerCliente(registerRequest);
      // Retorna una respuesta adecuada, por ejemplo, un mensaje de éxito
      // Considera retornar un DTO de respuesta para no exponer toda la entidad Usuario.
      return ResponseEntity.status(HttpStatus.CREATED).body("Cliente '" + newCliente.getCorreo() + "' registrado con éxito.");
    } catch (RuntimeException e) {
      // Captura las excepciones de negocio lanzadas desde el servicio (ej. correo ya registrado)
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
