package com.alexluta.ainetworkassistant.exception;

import lombok.Getter;

@Getter
public class DiagnosticRequestNotFoundException extends RuntimeException{
    private final Long id;

    public DiagnosticRequestNotFoundException(Long id){
        super("Diagnostic request with id [" + id + "] was not found");
        this.id = id;
    }
}
