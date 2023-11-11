package com.BancoFoda.BancoFoda.model.entities;

import java.util.Date;

public class Cartao
{
    private boolean credito;
    private Date validade;
    private String numero;
    private String codigoValidacao;

    public Cartao(){ }

    public boolean isCredito( )
    {
        return credito;
    }

    public void setCredito( boolean credito )
    {
        this.credito = credito;
    }

    public Date getValidade( )
    {
        return validade;
    }

    public void setValidade( Date validade )
    {
        this.validade = validade;
    }

    public String getNumero( )
    {
        return numero;
    }

    public void setNumero( String numero )
    {
        this.numero = numero;
    }

    public String getCodigoValidacao( )
    {
        return codigoValidacao;
    }

    public void setCodigoValidacao( String codigoValidacao )
    {
        this.codigoValidacao = codigoValidacao;
    }
}
