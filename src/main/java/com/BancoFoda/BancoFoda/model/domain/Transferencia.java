package com.BancoFoda.BancoFoda.model.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Transferencia
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private float valor;
    private Date data;
    private boolean credito;
    private boolean validada;
    @OneToOne
    private Conta origem;
    @OneToOne
    private Conta destino;

    public Transferencia( )
    {
    }

    public int getId( ) { return id; }

    public void setId( int id ) { this.id = id; }

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
