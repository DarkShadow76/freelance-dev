package com.ulima.curso.softwareii.freelancedev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "freelancers")
@PrimaryKeyJoinColumn(name = "id")
@Data
@NoArgsConstructor
@SuperBuilder
public class Freelancer extends Usuario{
  @OneToOne(mappedBy = "freelancer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
