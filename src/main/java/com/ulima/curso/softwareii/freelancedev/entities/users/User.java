package com.ulima.curso.softwareii.freelancedev.entities.users;

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
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class User {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(
      name = "id_user",
      updatable = false,
      nullable = false
  )
  private UUID idUser;

  // Agregar Validacion por nombre
  @NotBlank
  @Size(min = 4, max = 30)
  @Column(unique = true)
  private String name;

  // Agregar validacion si existe el correo en la DB
  @NotBlank
  @Column(
      unique = true,
      nullable = false
  )
  private String email;

  @NotBlank
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Column(nullable = false)
  private String HashedPassword;

  @JsonIgnoreProperties({"user", "handler", "hibernateLazyInitializer"})
  @JsonManagedReference
  @ManyToMany(
      targetEntity = Role.class,
      cascade = CascadeType.MERGE,
      fetch = FetchType.LAZY
  )
  @JoinTable(
      name = "user_roles",
      joinColumns = @JoinColumn(name = "id_user"),
      inverseJoinColumns = @JoinColumn(name = "id_role"),
      uniqueConstraints = {@UniqueConstraint(columnNames = {"id_user", "id_role"})}
  )
  private List<Role> roles = new ArrayList<>();

  private boolean enabled;

  @Transient
  private boolean admin;

  @PrePersist
  public void prePersist(){
    enabled=true;
  }
}
