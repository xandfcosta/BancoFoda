package com.BancoFoda.BancoFoda.exceptions;

public class UsuarioNotFoundException extends RuntimeException
{
    public UsuarioNotFoundException( String id )
    {
        super( "Usuario #" + id + " não encontrado" );
    }
}
