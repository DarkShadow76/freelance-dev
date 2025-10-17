package com.ulima.curso.softwareii.freelancedev.mappers;

import com.ulima.curso.softwareii.freelancedev.dto.response.FreelancerResponse;
import com.ulima.curso.softwareii.freelancedev.entities.users.Freelancer;

public class FreelancerMapper {

    public static FreelancerResponse toResponse(Freelancer freelancer) {
        if (freelancer == null) {
            return null;
        }

        FreelancerResponse response = new FreelancerResponse();
        response.idUser = freelancer.getIdUser();
        response.name = freelancer.getName();
        response.email = freelancer.getEmail();
        response.enabled = freelancer.isEnabled();

        return response;
    }
}
