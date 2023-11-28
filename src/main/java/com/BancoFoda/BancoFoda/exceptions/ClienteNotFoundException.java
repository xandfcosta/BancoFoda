package com.BancoFoda.BancoFoda.exceptions;

public class ClienteNotFoundException extends RuntimeException
{
    public ClienteNotFoundException(String id )
    {
        super( "Cliente #" + id + " não encontrado" );
    }
}
