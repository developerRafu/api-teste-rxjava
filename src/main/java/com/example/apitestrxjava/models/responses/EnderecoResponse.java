package com.example.apitestrxjava.models.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoResponse {
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
}
