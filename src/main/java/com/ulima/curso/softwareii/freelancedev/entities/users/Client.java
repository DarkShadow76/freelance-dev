package com.ulima.curso.softwareii.freelancedev.entities.users;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "id_user")
@Data
@NoArgsConstructor
@SuperBuilder
public class Client extends User {
  private String CompanyName;

  @Override
  public List<Role> getRoles(){
    return super.getRoles();
  }
}
