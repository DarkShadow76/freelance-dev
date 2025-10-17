package com.ulima.curso.softwareii.freelancedev.controllers;

import com.ulima.curso.softwareii.freelancedev.dto.request.RegisterRequest;
import com.ulima.curso.softwareii.freelancedev.entities.users.Freelancer;
import com.ulima.curso.softwareii.freelancedev.services.FreelancerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ulima.curso.softwareii.freelancedev.dto.response.FreelancerResponse;
import com.ulima.curso.softwareii.freelancedev.mappers.FreelancerMapper;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ver1/freelancer")
public class FreelancerController {
  private final FreelancerService freelancerService;

  public FreelancerController(FreelancerService freelancerService) {
    this.freelancerService = freelancerService;
  }

  @GetMapping
  public ResponseEntity<List<FreelancerResponse>> getAllFreelancers() {
    List<Freelancer> freelancers = freelancerService.findAll();
    List<FreelancerResponse> freelancerResponses = freelancers.stream()
        .map(FreelancerMapper::toResponse)
        .collect(Collectors.toList());
    return ResponseEntity.ok(freelancerResponses);
  }

  @PostMapping("/register")
  public ResponseEntity<FreelancerResponse> registerFreelancer(@RequestBody RegisterRequest registerRequest) {
    if (registerRequest == null || registerRequest.getName() == null || registerRequest.getEmail() == null || registerRequest.getPassword() == null) {
      return ResponseEntity.badRequest().build();
    }

    try {
      Freelancer newFreelancer = freelancerService.registerFreelancer(registerRequest);
      return ResponseEntity.status(HttpStatus.CREATED).body(FreelancerMapper.toResponse(newFreelancer));
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }
}
