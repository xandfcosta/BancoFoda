package com.BancoFoda.BancoFoda.resources;

import com.BancoFoda.BancoFoda.exceptions.ContaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice

public class ContaResourceAdvice
{
    @ResponseBody
    @ExceptionHandler( ContaNotFoundException.class)
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public String contaNotFoundHandler(ContaNotFoundException exception)
    {
        return exception.getMessage();
    }
}
