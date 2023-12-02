package com.BancoFoda.BancoFoda.resources;

import com.BancoFoda.BancoFoda.exceptions.PagamentoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class PagamentoResourceAdvice
{
    @ResponseBody
    @ExceptionHandler( PagamentoNotFoundException.class)
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public String pagamentoNotFoundHandler(PagamentoNotFoundException exception)
    {
        return exception.getMessage();
    }
}
