package com.swnat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Usuario no existe")
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1709513306241806460L;

    public UserNotFoundException() { super("El usuario no fue encontrado"); }
}
