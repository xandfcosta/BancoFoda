package com.BancoFoda.BancoFoda.exceptions;

public class TransferenciaNotFoundExcpetion extends RuntimeException
{
    public TransferenciaNotFoundExcpetion( int id )
    {
        super( "Transferencia #" + id + " não encontrado" );
    }
}
