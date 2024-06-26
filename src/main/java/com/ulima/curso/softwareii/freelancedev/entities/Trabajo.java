package com.ulima.curso.softwareii.freelancedev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "trabajos")
public class Trabajo {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(
      name = "id",
      updatable = false,
      nullable = false
  )
  private UUID id;

  // Definir cardinalidad Aqui
  @ManyToOne
  @JoinColumn(
      name = "id_cliente",
      nullable = false
  )
  private Cliente cliente;

  @NotBlank
  @Column(unique = true)
  private String titulo;

  @NotBlank
  private String descripcion;
  private String estado;

  @Lob
  @Column(name = "imagen", columnDefinition = "BLOB")
  private byte[] imagen;
  private char categoria;
  private char locacion;

  private Date fechainicio;

  private Date fechafin;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public byte[] getImagen() {
    return imagen;
  }

  public void setImagen(byte[] imagen) {
    this.imagen = imagen;
  }

  public char getCategoria() {
    return categoria;
  }

  public void setCategoria(char categoria) {
    this.categoria = categoria;
  }

  public char getLocacion() {
    return locacion;
  }

  public void setLocacion(char locacion) {
    this.locacion = locacion;
  }

  public Date getFechainicio() {
    return fechainicio;
  }

  public void setFechainicio(Date fechainicio) {
    this.fechainicio = fechainicio;
  }

  public Date getFechafin() {
    return fechafin;
  }

  public void setFechafin(Date fechafin) {
    this.fechafin = fechafin;
  }
}
