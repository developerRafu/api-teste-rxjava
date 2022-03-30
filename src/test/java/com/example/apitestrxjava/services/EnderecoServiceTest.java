package com.example.apitestrxjava.services;

import com.example.apitestrxjava.clients.EnderecoClient;
import com.example.apitestrxjava.helpers.EnderecoBuilder;
import com.example.apitestrxjava.mappers.EnderecoMapper;
import com.example.apitestrxjava.models.dtos.EnderecoDto;
import com.example.apitestrxjava.models.errors.EnderecoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EnderecoServiceTest {
    EnderecoClient client;
    EnderecoMapper mapper;
    EnderecoService service;

    @BeforeEach
    void setUp() {
        client = mock(EnderecoClient.class);
        mapper = mock(EnderecoMapper.class);
        service = new EnderecoService(client, mapper);
    }

    @Test
    void shouldCallClient() {
        service.getEndereco(any());
        verify(client).getEndereco(any());
    }

    @Test
    void shouldReturnEnderecoObject() {
        final var endereco = EnderecoBuilder.builder().fullFilled().getBuilder();
        final var enderecoDto = new EnderecoDto();

        when(client.getEndereco(any())).thenReturn(enderecoDto);

        when(mapper.toEnderecoResponse(any())).thenReturn(endereco);

        final var result = service.getEndereco("");

        assertNotNull(result);
    }

    @Test
    void itShouldReturnAnExceptionIfOccursAnyErrorOnClient() {
        when(client.getEndereco(any())).thenThrow(EnderecoException.class);
        assertThatThrownBy(() -> service.getEndereco(any()))
                .isInstanceOf(EnderecoException.class);
    }
}
