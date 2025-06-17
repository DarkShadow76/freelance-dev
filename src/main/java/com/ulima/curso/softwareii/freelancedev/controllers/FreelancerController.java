package com.ulima.curso.softwareii.freelancedev.controllers;

import com.ulima.curso.softwareii.freelancedev.entities.Freelancer;
import com.ulima.curso.softwareii.freelancedev.services.ClienteService;
import com.ulima.curso.softwareii.freelancedev.services.FreelancerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ver1/freelancer")
public class FreelancerController extends UsuarioController<Freelancer> {
  private final FreelancerService freelancerService;

  public FreelancerController(FreelancerService FreelancerService) {
    super(FreelancerService);
    this.freelancerService = FreelancerService;
  }
}
