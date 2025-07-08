package com.ulima.curso.softwareii.freelancedev.entities;

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
@Table(name = "clientes")
@PrimaryKeyJoinColumn(name = "id")
@Data
@NoArgsConstructor
@SuperBuilder
public class Cliente extends Usuario{
  @Override
  public List<Rol> getRoles(){
    return super.getRoles();
  }
}
