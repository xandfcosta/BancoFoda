package com.BancoFoda.BancoFoda.domain.model;

import java.util.ArrayList;

public class Credito
{
    private float valorTotal;
    private float valorAtual;
    private ArrayList< Fatura > faturas;

    public Credito( float valorTotal, float valorAtual, ArrayList< Fatura > faturas )
    {
        this.valorTotal = valorTotal;
        this.valorAtual = valorAtual;
        this.faturas = faturas;
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

    public ArrayList< Fatura > getFaturas( )
    {
        return faturas;
    }

    public void setFaturas( ArrayList< Fatura > faturas )
    {
        this.faturas = faturas;
    }
}
