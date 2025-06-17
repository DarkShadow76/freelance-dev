package com.ulima.curso.softwareii.freelancedev.services;

import com.ulima.curso.softwareii.freelancedev.dto.RegisterRequest;
import com.ulima.curso.softwareii.freelancedev.entities.Cliente;
import com.ulima.curso.softwareii.freelancedev.entities.Rol;
import com.ulima.curso.softwareii.freelancedev.repositories.ClienteRepository;
import com.ulima.curso.softwareii.freelancedev.repositories.RolRepository;
import com.ulima.curso.softwareii.freelancedev.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private RolRepository rolRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional(readOnly = true)
  public List<Cliente> findAll() {
    return clienteRepository.findAll();
  }

  @Override
  @Transactional
  public Cliente save(Cliente cliente) {
    // Hashear mas adelante la contraseña
    return clienteRepository.save(cliente);
  }

  @Override
  public boolean existByNombre(String nombre) {
    return clienteRepository.existsByNombre(nombre);
  }

  @Transactional
  public Cliente registerCliente(RegisterRequest request) {
    if (clienteRepository.existsByCorreo(request.getCorreo())){
      throw new IllegalStateException("Ya existe un usuario con correo: "+ request.getCorreo());
    }
    if (clienteRepository.existsByNombre(request.getNombre())){
      throw new IllegalStateException("Ya existe un usuario con nombre: "+ request.getNombre());
    }

    Cliente Ncliente = new Cliente();
    Ncliente.setNombre(request.getNombre());
    Ncliente.setCorreo(request.getCorreo());
    // Hasheamos la contraseña
    Ncliente.setContrasenia(passwordEncoder.encode(request.getContrasenia()));
    Ncliente.setAdmin(false);
    Ncliente.setEnabled(true);

    Rol defaulRole = rolRepository.findByNombre("ROLE_CLIENTE")
        .orElseThrow(() -> new RuntimeException("Error: No se encuentra el rol de cliente."));

    Ncliente.setRoles(Collections.singletonList(defaulRole));

    return clienteRepository.save(Ncliente);
  }
}
