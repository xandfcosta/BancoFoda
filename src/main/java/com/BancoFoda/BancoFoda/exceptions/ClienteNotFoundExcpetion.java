package com.BancoFoda.BancoFoda.exceptions;

public class ClienteNotFoundExcpetion extends RuntimeException
{
    public ClienteNotFoundExcpetion( String id )
    {
        super( "Cliente #" + id + " não encontrado" );
    }
}
