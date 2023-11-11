package com.BancoFoda.BancoFoda.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Fatura
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private float valor;
    private Date vencimento;
    private Date dataPagamento;

    public Fatura( float valor, Date vencimento, Date dataPagamento )
    {
        this.valor = valor;
        this.vencimento = vencimento;
        this.dataPagamento = dataPagamento;
    }

    public float getValor( )
    {
        return valor;
    }

    public void setValor( float valor )
    {
        this.valor = valor;
    }

    public Date getVencimento( )
    {
        return vencimento;
    }

    public void setVencimento( Date vencimento )
    {
        this.vencimento = vencimento;
    }

    public Date getDataPagamento( )
    {
        return dataPagamento;
    }

    public void setDataPagamento( Date dataPagamento )
    {
        this.dataPagamento = dataPagamento;
    }
}
