package com.alexluta.ainetworkassistant.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {

    private final Long id;

    public UserNotFoundException(Long id) {
        super("The user with id: " + id + " not found");
        this.id = id;
    }



}
