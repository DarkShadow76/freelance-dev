package com.ulima.curso.softwareii.freelancedev.services;

import java.util.List;

public interface UsuarioService<T> {
  List<T> findAll();
  T save(T usuario);
  boolean existByNombre(String nombre);
}
