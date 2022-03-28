package com.example.apitestrxjava.mappers;

import com.example.apitestrxjava.models.dtos.EnderecoDto;
import com.example.apitestrxjava.models.responses.EnderecoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    @Mapping(source = "logradouro", target = "rua")
    @Mapping(source = "localidade", target = "cidade")
    @Mapping(source = "uf", target = "estado")
    EnderecoResponse toEnderecoResponse(EnderecoDto dto);
}
