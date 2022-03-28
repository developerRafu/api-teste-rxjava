package com.example.apitestrxjava.models.errors;

import lombok.Getter;

@Getter
public class EnderecoException extends RuntimeException {
    public EnderecoException(String message) {
        super(message);
    }
}
