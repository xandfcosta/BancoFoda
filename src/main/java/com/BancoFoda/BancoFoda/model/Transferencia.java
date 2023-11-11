package com.BancoFoda.BancoFoda.model;

import java.util.Date;

public class Transferencia
{
    private float valor;
    private Date data;
    private boolean credito;
    private boolean validada;
    private Conta origem;
    private Conta destino;

    public Transferencia( float valor, Date data, boolean credito, boolean validada, Conta origem, Conta destino )
    {
        this.valor = valor;
        this.data = data;
        this.credito = credito;
        this.validada = validada;
        this.origem = origem;
        this.destino = destino;
    }

    public float getValor( )
    {
        return valor;
    }

    public void setValor( float valor )
    {
        this.valor = valor;
    }

    public Date getData( )
    {
        return data;
    }

    public void setData( Date data )
    {
        this.data = data;
    }

    public boolean isCredito( )
    {
        return credito;
    }

    public void setCredito( boolean credito )
    {
        this.credito = credito;
    }

    public boolean isValidada( )
    {
        return validada;
    }

    public void setValidada( boolean validada )
    {
        this.validada = validada;
    }

    public Conta getOrigem( )
    {
        return origem;
    }

    public void setOrigem( Conta origem )
    {
        this.origem = origem;
    }

    public Conta getDestino( )
    {
        return destino;
    }

    public void setDestino( Conta destino )
    {
        this.destino = destino;
    }
}
