package com.ulima.curso.softwareii.freelancedev.controllers;

import com.ulima.curso.softwareii.freelancedev.dto.RegisterRequest;
import com.ulima.curso.softwareii.freelancedev.entities.users.Freelancer;
import com.ulima.curso.softwareii.freelancedev.services.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ver1/freelancer")
public class FreelancerController extends UsuarioController<Freelancer> {
  private final FreelancerService freelancerService;

  @Autowired
  public FreelancerController(FreelancerService FreelancerService) {
    super(FreelancerService);
    this.freelancerService = FreelancerService;
  }

  @PostMapping("/register")
  public ResponseEntity<?> registerFreelancer(@RequestBody RegisterRequest registerRequest) {
    if (registerRequest == null || registerRequest.getNombre() == null || registerRequest.getCorreo() == null || registerRequest.getContrasenia() == null) {
      return ResponseEntity.badRequest().body("Datos de registro incompletos.");
    }

    try {
      Freelancer newFreelancer = freelancerService.registerFreelancer(registerRequest);
      return ResponseEntity.status(HttpStatus.CREATED).body("Freelancer '" + newFreelancer.getCorreo() + "' registrado con éxito.");
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
