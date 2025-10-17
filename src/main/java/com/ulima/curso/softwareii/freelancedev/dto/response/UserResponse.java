package com.ulima.curso.softwareii.freelancedev.dto.response;

import com.ulima.curso.softwareii.freelancedev.entities.users.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
  private UUID id_user;
  private String name;
  private String email;
  private boolean enabled;
  private boolean admin;
  private List<Role> roles;
}
