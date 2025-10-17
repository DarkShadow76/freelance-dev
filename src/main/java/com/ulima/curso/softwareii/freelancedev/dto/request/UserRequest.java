package com.ulima.curso.softwareii.freelancedev.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
  @NotBlank(message = "Name must not be blank")
  @Size(min = 4, max = 30, message = "Name must be between 4 and 30 characters")
  private String name;
  @NotBlank(message = "Email must not be blank")
  @Email(message = "Email must be valid")
  private String email;
  @NotBlank(message = "Password is mandatory")
  @Size(min = 8, message = "Password must be at least 8 characters")
  private String HashedPassword;


}
