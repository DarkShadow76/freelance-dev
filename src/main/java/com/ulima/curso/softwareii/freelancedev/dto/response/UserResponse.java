package com.ulima.curso.softwareii.freelancedev.dto.response;

import com.ulima.curso.softwareii.freelancedev.entities.users.Role;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserResponse {
  private UUID id_user;
  private String name;
  private String email;
  private boolean enabled;
  private boolean admin;
  private List<Role> roles;
}
