package com.ulima.curso.softwareii.freelancedev.entities.resumes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "curriculum_vitae")
@PrimaryKeyJoinColumn(name = "id_curriculum_vitae")
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumVitae {
  @Id
  @GeneratedValue(generator = "UUID")
  @Column(name = "id_curriculum_vitae", updatable = false, nullable = false)
  private UUID idCurriculumVitae;
  @Column(name = "full_name", length = 50)
  private String fullName;
  @Column(length = 50)
  private String email;
  @Column(name = "contact_phone", length = 30)
  private String contactPhone;
  @Column(name = "linkedin_profile_url", length = 100)
  private String linkedinUrl;
  // Optional: ADD more columns by Requeriment
  /**
   * "tech_skill":[
   *   "java",
   *   "spring","
   *   "devops",
   *   "CI/CD"
   * ]
   * **/
  @ElementCollection(fetch = FetchType.EAGER)
  @JsonIgnore
  @CollectionTable(name = "curriculum_skills", joinColumns = @JoinColumn(name = "id_curriculum_vitae"))
  @Column(name = "tech_skills")
  private List<String> techSkills; // May add field for Soft Skill in the future

  @Lob
  @Column(columnDefinition = "TEXT")
  private String bio;

  @Column(nullable = false, updatable = false)
  private Instant created_at;
  @Column(nullable = false)
  private Instant updated_at;

  // List<JobExperience> jobExperience;
  // List<EducationEntry> education;
  // List<Certification> certifications;

  @PrePersist
  protected void onCreated() {
    this.created_at = Instant.now();
    this.updated_at = Instant.now();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updated_at = Instant.now();
  }
}
