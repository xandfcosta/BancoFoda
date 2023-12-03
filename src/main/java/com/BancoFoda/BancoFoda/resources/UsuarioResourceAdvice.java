package com.BancoFoda.BancoFoda.resources;

import com.BancoFoda.BancoFoda.exceptions.UsuarioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class UsuarioResourceAdvice
{
    @ResponseBody
    @ExceptionHandler( UsuarioNotFoundException.class)
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public String usuarioNotFoundHandler(UsuarioNotFoundException exception)
    {
        return exception.getMessage();
    }
}
