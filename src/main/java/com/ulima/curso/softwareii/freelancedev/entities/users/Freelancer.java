package com.ulima.curso.softwareii.freelancedev.entities.users;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "freelancer")
@PrimaryKeyJoinColumn(name = "id_user")
@Getter
@Setter
@NoArgsConstructor
public class Freelancer extends User {
}
