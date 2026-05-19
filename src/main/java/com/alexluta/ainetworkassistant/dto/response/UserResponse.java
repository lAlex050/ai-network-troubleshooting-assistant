package com.alexluta.ainetworkassistant.dto.response;

import lombok.*;

import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String phoneNumber;
    private Instant createdAt;
}
