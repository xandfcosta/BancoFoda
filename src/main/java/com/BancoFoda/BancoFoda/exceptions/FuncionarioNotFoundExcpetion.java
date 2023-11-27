package com.BancoFoda.BancoFoda.exceptions;

public class FuncionarioNotFoundExcpetion extends RuntimeException
{
    public FuncionarioNotFoundExcpetion( String id )
    {
        super( "Funcionario #" + id + " não encontrado" );
    }
}
