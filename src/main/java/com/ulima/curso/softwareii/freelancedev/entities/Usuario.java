package com.ulima.curso.softwareii.freelancedev.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Usuario {
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

  // Agregar Validacion por nombre
  @NotBlank
  @Size(min = 4, max = 30)
  @Column(unique = true)
  private String nombre;

  // Agregar validacion si existe el correo en la DB
  @NotBlank
  @Column(
      unique = true,
      nullable = false
  )
  private String correo;

  @NotBlank
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Column(nullable = false)
  private String contrasenia;

  @JsonIgnoreProperties({"usuario", "handler", "hibernateLazyInitializer"})
  @JsonManagedReference
  @ManyToMany(
      targetEntity = Rol.class,
      cascade = CascadeType.MERGE,
      fetch = FetchType.LAZY
  )
  @JoinTable(
      name = "usuario_roles",
      joinColumns = @JoinColumn(name = "usuario_id"),
      inverseJoinColumns = @JoinColumn(name = "rol_id"),
      uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "rol_id"})}
  )
  private List<Rol> roles = new ArrayList<>();

  private boolean enabled;

  @Transient
  private boolean admin;

  @PrePersist
  public void prePersist(){
    enabled=true;
  }
}
