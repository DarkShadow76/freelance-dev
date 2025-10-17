package com.ulima.curso.softwareii.freelancedev.dto.response;


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
public class FreelancerResponse {
  public UUID idUser;
  public String name;
  public String email;
  public boolean enabled;
}
