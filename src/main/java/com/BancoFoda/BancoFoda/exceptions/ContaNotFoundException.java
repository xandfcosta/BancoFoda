package com.BancoFoda.BancoFoda.exceptions;

public class ContaNotFoundException extends RuntimeException
{
    public ContaNotFoundException(int id )
    {
        super( "Conta #" + id + " não encontrado" );
    }
}
