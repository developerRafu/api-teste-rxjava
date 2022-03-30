package com.example.apitestrxjava.services;

import com.example.apitestrxjava.clients.StarWarsClient;
import com.example.apitestrxjava.models.dtos.StarWarsDto;
import com.example.apitestrxjava.models.errors.StarWarsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class StarWarsServiceTest {

    StarWarsClient client;

    StarWarsService service;

    @BeforeEach
    void setUp() {
        client = mock(StarWarsClient.class);
        service = new StarWarsService(client);
    }

    @Test
    void itShouldCallClient() {
        StarWarsDto dto = new StarWarsDto();
        dto.setName("Algum nome");
        when(client.getPeople(any())).thenReturn(dto);
        service.getName(any());
        verify(client).getPeople(any());
    }

    @Test
    void itShouldReturnNameOfStarWarsDto() {
        StarWarsDto dto = new StarWarsDto();
        dto.setName("Algum nome");
        when(client.getPeople(any())).thenReturn(dto);
        final var result = service.getName(any());
        assertNotNull(result);
    }

    @Test
    void itShouldThrowExceptionIfOccursAnyErrorInTheClient() {
        StarWarsDto dto = new StarWarsDto();
        dto.setName("Algum nome");
        when(client.getPeople(any())).thenThrow(RuntimeException.class);
        assertThrows(StarWarsException.class, () -> service.getName(any()));
    }
}
