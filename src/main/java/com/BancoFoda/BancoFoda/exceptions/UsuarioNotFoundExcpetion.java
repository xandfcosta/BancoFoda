package com.BancoFoda.BancoFoda.exceptions;

public class UsuarioNotFoundExcpetion extends RuntimeException
{
    public UsuarioNotFoundExcpetion( String id )
    {
        super( "Usuário #" + id + " não encontrado" );
    }
}
