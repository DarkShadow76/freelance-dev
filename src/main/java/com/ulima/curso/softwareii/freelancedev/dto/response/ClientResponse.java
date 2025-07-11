package com.ulima.curso.softwareii.freelancedev.dto.response;

import com.ulima.curso.softwareii.freelancedev.entities.users.Role;

import java.util.List;
import java.util.UUID;

public class ClientResponse {
  private UUID idUser;
  private String name;
  private String email;
  private boolean enabled;
  private List<Role> roles;
  private String companyName;
}
