package com.example.apitestrxjava.controllers;

import com.example.apitestrxjava.models.dtos.Message;
import com.example.apitestrxjava.models.enums.TypeMessage;
import com.example.apitestrxjava.models.errors.EnderecoException;
import com.example.apitestrxjava.models.errors.StarWarsException;
import com.example.apitestrxjava.models.errors.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {
    private static Integer BAD_REQUEST = 400;

    @ExceptionHandler(EnderecoException.class)
    public ResponseEntity<Message> error(EnderecoException ex, HttpServletRequest servlet) {
        Message message = new Message();
        message.setStatus(BAD_REQUEST);
        message.setType(TypeMessage.ERROR);
        message.setText(ex.getMessage());
        return ResponseEntity.status(BAD_REQUEST).body(message);
    }

    @ExceptionHandler(StarWarsException.class)
    public ResponseEntity<Message> error(StarWarsException ex, HttpServletRequest servlet) {
        Message message = new Message();
        message.setStatus(BAD_REQUEST);
        message.setType(TypeMessage.ERROR);
        message.setText(ex.getMessage());
        return ResponseEntity.status(BAD_REQUEST).body(message);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<Message> error(UserException ex, HttpServletRequest servlet) {
        Message message = new Message();
        message.setStatus(BAD_REQUEST);
        message.setType(TypeMessage.ERROR);
        message.setText(ex.getMessage());
        return ResponseEntity.status(BAD_REQUEST).body(message);
    }
}
