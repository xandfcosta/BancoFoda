package com.BancoFoda.BancoFoda.exceptions;

public class CartaoNotFoundExcpetion extends RuntimeException
{
    public CartaoNotFoundExcpetion( String id )
    {
        super( "Cartao #" + id + " não encontrado" );
    }
}
