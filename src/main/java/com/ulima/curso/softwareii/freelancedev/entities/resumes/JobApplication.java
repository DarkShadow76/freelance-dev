package com.ulima.curso.softwareii.freelancedev.entities.resumes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Table(name = "job_application")
@PrimaryKeyJoinColumn(name = "id_job_application")
@NoArgsConstructor
@AllArgsConstructor
public class JobApplication {
  // GenericGenerator -> Deprecated
  @Id
  @GeneratedValue(generator = "UUID")
  @Column(updatable = false, nullable = false, name = "id_job_application")
  private UUID idJobApplication; // PK

  @Column(updatable = false, nullable = false, name = "id_freelancer")
  private UUID idFreelancer; // FK

  @Column(updatable = false, nullable = false, name = "id_job_offer")
  private UUID idJobOffer; // FK

}
