package com.example.apitestrxjava.models.errors;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}
