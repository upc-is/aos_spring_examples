package com.acme.learningcenter.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException{

    public ConflictException(String resourceName, String dni) {
        super(String.format("El DNI ingresado: %s, ya existe en la tabla %s", dni, resourceName ));
    }
}
