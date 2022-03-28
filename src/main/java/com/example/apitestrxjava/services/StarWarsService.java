package com.example.apitestrxjava.services;

import com.example.apitestrxjava.clients.StarWarsClient;
import com.example.apitestrxjava.models.errors.StarWarsException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StarWarsService {
    private final StarWarsClient client;

    public String getName(Long id) {
        try {
            return client.getPeople(id).getName();
        } catch (RuntimeException ex) {
            throw new StarWarsException("Erro to reach star wars api");
        }
    }
}
