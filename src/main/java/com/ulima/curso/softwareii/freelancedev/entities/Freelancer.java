package com.ulima.curso.softwareii.freelancedev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "freelancers")
@PrimaryKeyJoinColumn(name = "id")
@Data
@NoArgsConstructor
@SuperBuilder
public class Freelancer extends Usuario{
  @OneToOne(mappedBy = "freelancer", cascade = CascadeType.ALL)
  @JsonIgnore
  private Portafolio portafolio;

  private float calificacion;
  private char tipoPriv;
  private int numTrabajos;

  @Override
  public List<Rol> getRoles(){
    return super.getRoles();
  }
}
