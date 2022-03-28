package com.example.apitestrxjava.clients;

import com.example.apitestrxjava.models.dtos.EnderecoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://viacep.com.br/ws", path = "", name = "via-cep")
public interface EnderecoClient {
    @GetMapping("{cep}/json/")
    EnderecoDto getEndereco(@PathVariable String cep);
}
