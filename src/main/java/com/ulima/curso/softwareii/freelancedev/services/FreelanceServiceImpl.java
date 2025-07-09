package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.dto.RegisterRequest;
import com.ulima.curso.softwareii.freelancedev.entities.users.Freelancer;
import com.ulima.curso.softwareii.freelancedev.entities.users.Rol;
import com.ulima.curso.softwareii.freelancedev.repositories.FreelancerRepository;
import com.ulima.curso.softwareii.freelancedev.repositories.RolRepository;
import com.ulima.curso.softwareii.freelancedev.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class FreelanceServiceImpl implements FreelancerService {
  @Autowired
  private FreelancerRepository freelancerRepository;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private RolRepository rolRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public List<Freelancer> findAll() {
    return null;
  }

  @Override
  public Freelancer save(Freelancer freelancer) {
    return null;
  }

  @Override
  public boolean existByNombre(String nombre) {
    return false;
  }

  @Override
  @Transactional
  public Freelancer registerFreelancer(RegisterRequest request) {
    if (usuarioRepository.existsByCorreo(request.getCorreo())){
      throw new IllegalStateException("Ya existe un usuario con correo: "+ request.getCorreo());
    }
    if (usuarioRepository.existsByNombre(request.getNombre())){
      throw new IllegalStateException("Ya existe un usuario con nombre: "+ request.getNombre());
    }

    Freelancer NFreelancer = new Freelancer();
    NFreelancer.setNombre(request.getNombre());
    NFreelancer.setCorreo(request.getCorreo());
    // Hasheamos la contraseña
    NFreelancer.setContrasenia(passwordEncoder.encode(request.getContrasenia()));
    NFreelancer.setAdmin(false);
    NFreelancer.setEnabled(true);

    Rol defaulRole = rolRepository.findByNombre("ROLE_FREELANCER")
        .orElseThrow(() -> new RuntimeException("Error: No se encuentra el rol de cliente."));

    NFreelancer.setRoles(Collections.singletonList(defaulRole));

    return freelancerRepository.save(NFreelancer);
  }
}
