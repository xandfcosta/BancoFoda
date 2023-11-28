package com.BancoFoda.BancoFoda.exceptions;

public class FaturaNotFoundException extends RuntimeException
{
    public FaturaNotFoundException(int id )
    {
        super( "Fatura #" + id + " não encontrado" );
    }
}
