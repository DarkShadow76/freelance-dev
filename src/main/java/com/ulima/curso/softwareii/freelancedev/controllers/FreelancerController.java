package com.ulima.curso.softwareii.freelancedev.controllers;

import com.ulima.curso.softwareii.freelancedev.entities.Freelancer;
import com.ulima.curso.softwareii.freelancedev.services.ClienteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ver1/freelancer")
public class FreelancerController extends UsuarioController<Freelancer> {
  public FreelancerController(ClienteService clienteService) {
    super(clienteService);
  }
}
