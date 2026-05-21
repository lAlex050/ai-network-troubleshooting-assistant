package com.alexluta.ainetworkassistant.exception;

import lombok.Getter;

@Getter
public class UserNotFoundByUsernameException extends RuntimeException{
    private final String username;

    public UserNotFoundByUsernameException(String username){
        super("User with username: [" + username + "] was not found");
        this.username = username;
    }
}
