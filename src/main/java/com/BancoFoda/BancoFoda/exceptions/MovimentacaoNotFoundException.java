package com.BancoFoda.BancoFoda.exceptions;

public class MovimentacaoNotFoundException extends RuntimeException
{
    public MovimentacaoNotFoundException( int id )
    {
        super( "Movimentacao #" + id + " não encontrada" );
    }
}
