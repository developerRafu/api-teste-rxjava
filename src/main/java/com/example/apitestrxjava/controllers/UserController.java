package com.example.apitestrxjava.controllers;

import com.example.apitestrxjava.models.responses.UserResponse;
import com.example.apitestrxjava.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService service;

    @GetMapping
    public ResponseEntity<UserResponse> get() {
        return ResponseEntity.ok().body(service.getUser());
    }
}
