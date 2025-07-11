package com.ulima.curso.softwareii.freelancedev.dto.request;

import com.ulima.curso.softwareii.freelancedev.entities.users.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class FreelancerRequest {
  // Add to application.yml
  private final String raw_role="Job Applicant's";

  @NotBlank(message = "{row_role} Name must not be blank")
  @Size(min = 4, max = 30, message = "Name must be between 4 and 30 characters")
  private String name;
  @NotBlank(message = "{row_role} Email must not be blank")
  @Email(message = "{row_role} Email must be valid")
  private String email;
  @NotBlank(message = "{row_role} Password is mandatory")
  @Size(min = 8, message = "{row_role} Password must be at least 8 characters")
  private String HashedPassword;
  @NotBlank(message = "{row_role} Company name is mandatory")
  private String CompanyName;

  private List<Role> roles;
}
