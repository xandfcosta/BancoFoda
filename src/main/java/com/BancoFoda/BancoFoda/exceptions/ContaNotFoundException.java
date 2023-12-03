package com.BancoFoda.BancoFoda.exceptions;

public class ContaNotFoundException extends RuntimeException
{
    public ContaNotFoundException( Long id )
    {
        super( "Conta #" + id + " não encontrado" );
    }

    public ContaNotFoundException( )
    {

    }
}
