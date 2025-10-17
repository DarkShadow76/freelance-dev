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

public class ClientResponse {
  private UUID idUser;
  private String name;
  private String email;
  private boolean enabled;
  private List<Role> roles;
  private String companyName;
}
