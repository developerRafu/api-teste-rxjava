package com.example.apitestrxjava.helpers;

import com.example.apitestrxjava.models.responses.EnderecoResponse;

public class EnderecoBuilder {
    private EnderecoResponse endereco;

    private EnderecoBuilder() {
        endereco = new EnderecoResponse();
    }

    public static EnderecoBuilder builder() {
        return new EnderecoBuilder();
    }

    public EnderecoBuilder fullFilled() {
        endereco.setBairro("Algum bairro");
        endereco.setCep("00000-000");
        endereco.setEstado("Algum estado");
        endereco.setCidade("Alguma cidade");
        endereco.setRua("Alguma rua");
        return this;
    }

    public EnderecoResponse getBuilder() {
        return endereco;
    }
}
