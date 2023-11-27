package com.BancoFoda.BancoFoda.exceptions;

public class FaturaNotFoundExcpetion extends RuntimeException
{
    public FaturaNotFoundExcpetion( int id )
    {
        super( "Fatura #" + id + " não encontrado" );
    }
}
