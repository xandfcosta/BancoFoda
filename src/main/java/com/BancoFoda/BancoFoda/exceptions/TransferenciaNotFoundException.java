package com.BancoFoda.BancoFoda.exceptions;

public class TransferenciaNotFoundException extends RuntimeException
{
    public TransferenciaNotFoundException(String id )
    {
        super( "Transferencia #" + id + " não encontrado" );
    }
}
