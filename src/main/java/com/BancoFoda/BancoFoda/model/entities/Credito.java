package com.BancoFoda.BancoFoda.model.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Credito
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private float valorTotal;
    private float valorAtual;
    private Set< Fatura > faturas;

    public Credito(){ }

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

    public Set< Fatura > getFaturas( )
    {
        return faturas;
    }

    public void setFaturas( Set< Fatura > faturas )
    {
        this.faturas = faturas;
    }
}
