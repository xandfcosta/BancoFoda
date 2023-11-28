package com.BancoFoda.BancoFoda.exceptions;

public class PagamentoNotFoundException extends RuntimeException
{
    public PagamentoNotFoundException( int id )
    {
        super( "Pagamento #" + id + " não encontrado" );
    }
}
