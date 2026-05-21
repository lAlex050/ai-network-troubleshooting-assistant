package com.alexluta.ainetworkassistant.exception;

import lombok.Getter;

@Getter
public class UserNotFoundByEmailException extends RuntimeException{

    private final String email;

    public UserNotFoundByEmailException(String email){
        super("User with email: [" + email + "] was not found");
        this.email = email;
    }
}
