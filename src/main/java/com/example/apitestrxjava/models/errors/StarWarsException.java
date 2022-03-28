package com.example.apitestrxjava.models.errors;

import lombok.Getter;

@Getter
public class StarWarsException extends RuntimeException {
    public StarWarsException(String message) {
        super(message);
    }
}
