package com.ulima.curso.softwareii.freelancedev.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "clientes")
@PrimaryKeyJoinColumn(name = "id")
@Data
@NoArgsConstructor
@SuperBuilder
public class Cliente extends Usuario{

}
