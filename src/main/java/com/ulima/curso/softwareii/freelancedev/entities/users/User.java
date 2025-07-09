package com.ulima.curso.softwareii.freelancedev.entities.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class User {
  @Id
  @GeneratedValue(generator = "UUID")
  @Deprecated
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

  @Column(unique = true)
  private String name;

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

  public UUID getIdUser() {
    return idUser;
  }

  public void setIdUser(UUID idUser) {
    this.idUser = idUser;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getHashedPassword() {
    return HashedPassword;
  }

  public void setHashedPassword(String hashedPassword) {
    HashedPassword = hashedPassword;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }
}
