package com.ulima.curso.softwareii.freelancedev.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "freelancers")
@PrimaryKeyJoinColumn(name = "id")
public class Freelancer extends Usuario{
  @OneToOne(mappedBy = "freelancer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Portafolio portafolio;
  private float calificacion;
  private char tipoPriv;
  private int numTrabajos;

  public Portafolio getPortafolio() {
    return portafolio;
  }

  public void setPortafolio(Portafolio portafolio) {
    this.portafolio = portafolio;
  }

  public float getCalificacion() {
    return calificacion;
  }

  public void setCalificacion(float calificacion) {
    this.calificacion = calificacion;
  }

  public char getTipoPriv() {
    return tipoPriv;
  }

  public void setTipoPriv(char tipoPriv) {
    this.tipoPriv = tipoPriv;
  }

  public int getNumTrabajos() {
    return numTrabajos;
  }

  public void setNumTrabajos(int numTrabajos) {
    this.numTrabajos = numTrabajos;
  }
}
