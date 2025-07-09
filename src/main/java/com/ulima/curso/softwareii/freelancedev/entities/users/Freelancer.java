package com.ulima.curso.softwareii.freelancedev.entities.users;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "freelancer")
@PrimaryKeyJoinColumn(name = "id_user")
@Data
@NoArgsConstructor
@SuperBuilder
public class Freelancer extends User {

  @Override
  public List<Role> getRoles(){
    return super.getRoles();
  }
}
