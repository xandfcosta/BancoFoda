package com.BancoFoda.BancoFoda.exceptions;

public class TransferenciaNotFoundExcpetion extends RuntimeException
{
    public TransferenciaNotFoundExcpetion( String id )
    {
        super( "Transferencia #" + id + " não encontrado" );
    }
}
