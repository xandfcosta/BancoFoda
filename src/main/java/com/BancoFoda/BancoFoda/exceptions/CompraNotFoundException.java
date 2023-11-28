package com.BancoFoda.BancoFoda.exceptions;

public class CompraNotFoundException extends RuntimeException {
    public CompraNotFoundException(int id)
        {
            super( "Compra #" + Integer.toString(id) + " não encontrada" );
        }
}
