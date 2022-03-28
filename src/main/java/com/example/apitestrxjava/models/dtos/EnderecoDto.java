package com.example.apitestrxjava.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDto {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
