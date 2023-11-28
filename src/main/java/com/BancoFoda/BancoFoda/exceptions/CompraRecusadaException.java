package com.BancoFoda.BancoFoda.exceptions;

public class CompraRecusadaException extends RuntimeException {
    public CompraRecusadaException(String id)
    {
        super( "Compra #" + id + " recusada" );
    }
}
