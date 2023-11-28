package com.BancoFoda.BancoFoda.exceptions;

public class CartaoNotFoundException extends RuntimeException
{
    public CartaoNotFoundException(String id )
    {
        super( "Cartao #" + id + " não encontrado" );
    }
}
