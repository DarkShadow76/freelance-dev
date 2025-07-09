package com.ulima.curso.softwareii.freelancedev.services;

import java.util.List;

public interface UserService<T> {
  List<T> findAll();
  T save(T usuario);
  boolean existByName(String nombre);
}
