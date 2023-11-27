package com.BancoFoda.BancoFoda.model.domain;

import jakarta.persistence.*;

@Entity
public class Credito
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private float valorTotal;
    private float valorAtual;

    public Credito( )
    {
    }

    public int getId( )
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public float getValorTotal( )
    {
        return valorTotal;
    }

    public void setValorTotal( float valorTotal )
    {
        this.valorTotal = valorTotal;
    }

    public float getValorAtual( )
    {
        return valorAtual;
    }

    public void setValorAtual( float valorAtual )
    {
        this.valorAtual = valorAtual;
    }

}
