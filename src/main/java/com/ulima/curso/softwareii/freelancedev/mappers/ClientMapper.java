package com.ulima.curso.softwareii.freelancedev.mappers;

import com.ulima.curso.softwareii.freelancedev.dto.response.ClientResponse;
import com.ulima.curso.softwareii.freelancedev.entities.users.Client;

public class ClientMapper {

    public static ClientResponse toResponse(Client client) {
        if (client == null) {
            return null;
        }

        ClientResponse response = new ClientResponse();
        response.idUser = client.getIdUser();
        response.name = client.getName();
        response.email = client.getEmail();
        response.enabled = client.isEnabled();
        response.companyName = client.getCompanyName();

        return response;
    }
}
