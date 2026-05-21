package com.alexluta.ainetworkassistant.service;

import com.alexluta.ainetworkassistant.dto.request.CreateUserRequest;
import com.alexluta.ainetworkassistant.dto.response.UserResponse;
import com.alexluta.ainetworkassistant.entity.User;
import com.alexluta.ainetworkassistant.exception.*;
import com.alexluta.ainetworkassistant.mapper.UserMapper;
import com.alexluta.ainetworkassistant.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    private void validateUniqueUserFields(CreateUserRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new DuplicateResourceException("Username already in use");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email address already in use");
        }

        if (userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new DuplicateResourceException("Phone number already in use");
        }
    }



    public UserResponse addUser(CreateUserRequest request) {
        validateUniqueUserFields(request);
        User user = userMapper.toEntity(request);
        return userMapper.toResponse(userRepository.save(user));
    }

    public List<UserResponse> getUsers(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toResponse)
                .toList();
        }

    public UserResponse getUserById (Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return userMapper.toResponse(user);
    }

    public UserResponse getUserByEmail (String email){
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundByEmailException(email));
        return userMapper.toResponse(user);
    }

    public UserResponse getUserByUsername(String username){
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundByUsernameException(username));
        return userMapper.toResponse(user);
    }

    public UserResponse getUserByPhoneNumber(String phoneNumber){
        User user = userRepository.findUserByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new UserNotFoundByPhoneNumberException(phoneNumber));
        return userMapper.toResponse(user);
    }







}
