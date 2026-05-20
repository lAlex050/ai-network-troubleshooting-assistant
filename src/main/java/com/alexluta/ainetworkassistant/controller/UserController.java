package com.alexluta.ainetworkassistant.controller;

import com.alexluta.ainetworkassistant.dto.request.CreateUserRequest;
import com.alexluta.ainetworkassistant.dto.response.UserResponse;
import com.alexluta.ainetworkassistant.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> addUser(@Valid @RequestBody CreateUserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(request));
    }
}
