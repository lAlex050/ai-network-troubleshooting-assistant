package com.alexluta.ainetworkassistant.exception;

import lombok.Getter;

@Getter
public class UserNotFoundByPhoneNumberException extends RuntimeException{
    private final String phoneNumber;

    public UserNotFoundByPhoneNumberException(String phoneNumber){
        super("User with phone number: [" + phoneNumber + "] was not found");
        this.phoneNumber = phoneNumber;
    }
}
