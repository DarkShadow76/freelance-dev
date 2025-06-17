package com.ulima.curso.softwareii.freelancedev.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
  @NotBlank
  @Size(min = 4, max = 15)
  private String nombre;

  @NotBlank
  @Email
  private String correo;

  @NotBlank
  @Size(min = 8)
  private String contrasenia;
}
