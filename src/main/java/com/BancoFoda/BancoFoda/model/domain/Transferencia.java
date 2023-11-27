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
    @ManyToOne
    private Conta origem;
    @ManyToOne
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
