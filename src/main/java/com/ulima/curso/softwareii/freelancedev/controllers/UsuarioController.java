package com.ulima.curso.softwareii.freelancedev.controllers;

import com.ulima.curso.softwareii.freelancedev.entities.Usuario;
import com.ulima.curso.softwareii.freelancedev.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
  @Autowired
  private UsuarioService service;

  @GetMapping
  public List<Usuario> list(){
    return service.findAll();
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody Usuario usuario) {
    // Agregar Validaciones
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario));
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody Usuario usuario) {
    usuario.setAdmin(false);
    return create(usuario);
  }

  // Agregar Validaciones
}
