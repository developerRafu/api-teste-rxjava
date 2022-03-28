package com.example.apitestrxjava.models.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String name;
    private String favoriteChar;
    private String cep;
    private Long stId;
    private EnderecoResponse endereco;
}
