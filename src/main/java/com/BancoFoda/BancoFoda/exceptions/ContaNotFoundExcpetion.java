package com.BancoFoda.BancoFoda.exceptions;

public class ContaNotFoundExcpetion extends RuntimeException
{
    public ContaNotFoundExcpetion( int id )
    {
        super( "Conta #" + id + " não encontrado" );
    }
}
