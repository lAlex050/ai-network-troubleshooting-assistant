package com.alexluta.ainetworkassistant.controller;

import com.alexluta.ainetworkassistant.dto.request.CreateUserRequest;
import com.alexluta.ainetworkassistant.dto.response.UserResponse;
import com.alexluta.ainetworkassistant.entity.User;
import com.alexluta.ainetworkassistant.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

    @GetMapping("/users/by-email")
    public ResponseEntity<UserResponse> getUserByEmail(@Valid @RequestParam String email){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByEmail(email));
    }

    @GetMapping("/users/by-username")
    public ResponseEntity<UserResponse> getUserByUsername(@Valid @RequestParam String username){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByUsername(username));
    }

    @GetMapping("/users/by-phone")
    public ResponseEntity<UserResponse> getUserByPhoneNumber(@Valid @RequestParam String phoneNumber){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByPhoneNumber(phoneNumber));
    }
}
