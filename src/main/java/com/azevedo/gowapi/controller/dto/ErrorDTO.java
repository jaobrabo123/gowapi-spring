package com.azevedo.gowapi.controller.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErrorDTO(
        int status,
        String message,
        List<FieldError> errors
) {

    public static ErrorDTO defaultResponse(String message){
        return new ErrorDTO(HttpStatus.BAD_REQUEST.value(), message, List.of());
    }

    public static ErrorDTO notFoundResponse(String message){
        return new ErrorDTO(HttpStatus.NOT_FOUND.value(), message, List.of());
    }

}
