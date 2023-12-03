package com.BancoFoda.BancoFoda.resources;

import com.BancoFoda.BancoFoda.exceptions.MovimentacaoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice

public class MovimentacaoResourceAdvice
{
    @ResponseBody
    @ExceptionHandler( MovimentacaoNotFoundException.class)
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public String movimentacaoNotFoundHandler(MovimentacaoNotFoundException exception)
    {
        return exception.getMessage();
    }
}
