package com.example.apitestrxjava.services;

import com.example.apitestrxjava.clients.EnderecoClient;
import com.example.apitestrxjava.mappers.EnderecoMapper;
import com.example.apitestrxjava.models.errors.EnderecoException;
import com.example.apitestrxjava.models.responses.EnderecoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnderecoService {
    private final EnderecoClient client;
    private final EnderecoMapper mapper;

    public EnderecoResponse getEndereco(String cep) {
        try {
            final var endereco = client.getEndereco(cep);
            return mapper.toEnderecoResponse(endereco);
        } catch (RuntimeException exception) {
            throw new EnderecoException("Erro to reach via-cep");
        }
    }
}
