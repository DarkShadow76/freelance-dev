package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.dto.RegisterRequest;
import com.ulima.curso.softwareii.freelancedev.entities.Freelancer;
import com.ulima.curso.softwareii.freelancedev.entities.Usuario;

import java.util.List;

public interface FreelancerService extends UsuarioService<Freelancer>{
  List<Freelancer> findAll();
  Freelancer save(Freelancer freelancer);
  Freelancer registerFreelancer(RegisterRequest request);
  boolean existByNombre(String nombre);
}
