package com.ulima.curso.softwareii.freelancedev.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
  @NotBlank
  @Size(min = 4, max = 15)
  private String name;

  @NotBlank
  @Email
  private String email;

  @NotBlank
  @Size(min = 8)
  private String password;
}
