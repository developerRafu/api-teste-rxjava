package com.example.apitestrxjava.clients;

import com.example.apitestrxjava.models.dtos.EnderecoDto;
import com.example.apitestrxjava.models.dtos.StarWarsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://swapi.dev/api", path = "people", name = "st-client")
public interface StarWarsClient {
    @GetMapping("{id}")
    StarWarsDto getPeople(@PathVariable Long id);
}
