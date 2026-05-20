package com.alexluta.ainetworkassistant.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private Integer status;
    private String errorCode;
    private String errorMessage;
    private Instant timestamp;
    private String path;
}
