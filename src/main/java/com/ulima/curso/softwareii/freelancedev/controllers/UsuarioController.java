package com.ulima.curso.softwareii.freelancedev.controllers;

import com.ulima.curso.softwareii.freelancedev.dto.RegisterRequest;
import com.ulima.curso.softwareii.freelancedev.entities.Usuario;
import com.ulima.curso.softwareii.freelancedev.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ver1/usuario")
public abstract class UsuarioController<T extends Usuario> {
  @Autowired
  private UsuarioService<T> service;

  @GetMapping
  public List<T> list(){
    return service.findAll();
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody T usuario) {
    // Agregar Validaciones
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario));
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
    if (registerRequest == null || registerRequest.getNombre() == null || registerRequest.getCorreo() == null || registerRequest.getContrasenia() == null) {
      return ResponseEntity.badRequest().body("Datos de registro incompletos.");
    }

    Usuario newUsuario = new Usuario() {
    };

    System.out.println("Received registration request for: " + registerRequest.getCorreo());
    return ResponseEntity.status(HttpStatus.CREATED).body("Registro recibido. Lógica de negocio pendiente.");
    //usuario.setAdmin(false);
    //return create(usuario);
  }

  // Agregar Validaciones
}
