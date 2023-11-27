package com.BancoFoda.BancoFoda.exceptions;

public class CreditoNotFoundExcpetion extends RuntimeException
{
    public CreditoNotFoundExcpetion( int id )
    {
        super( "Credito #" + id + " não encontrado" );
    }
}
