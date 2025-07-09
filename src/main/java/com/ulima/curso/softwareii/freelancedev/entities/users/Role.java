package com.ulima.curso.softwareii.freelancedev.entities.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

/** TODO
 * Change type of var for id_role (Use LONG)
 *
 * **/
@Entity
@Table(name = "role")
@PrimaryKeyJoinColumn(name = "id_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "id_role", updatable = false, nullable = false)
  private UUID idRole;

  @Column(unique = true, name = "name_role")
  private String RoleName;

  @JsonIgnore
  @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
  private List<User> users;
}
