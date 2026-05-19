package com.alexluta.ainetworkassistant.mapper;

import com.alexluta.ainetworkassistant.dto.request.CreateUserRequest;
import com.alexluta.ainetworkassistant.dto.response.UserResponse;
import com.alexluta.ainetworkassistant.entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public User toEntity(CreateUserRequest request){

    return User.builder()
            .name(request.getName())
            .username(request.getUsername())
            .passwordHash(request.getPassword())
            .email(request.getEmail())
            .phoneNumber(request.getPhoneNumber())
            .build();

    }

    public UserResponse toResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .build();
    }

}
