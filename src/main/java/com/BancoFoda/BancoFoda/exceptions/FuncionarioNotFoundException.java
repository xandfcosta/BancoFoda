package com.BancoFoda.BancoFoda.exceptions;

public class FuncionarioNotFoundException extends RuntimeException
{
    public FuncionarioNotFoundException(String id )
    {
        super( "Funcionario #" + id + " não encontrado" );
    }
}
