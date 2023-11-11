package com.BancoFoda.BancoFoda.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Cartao
{
    @Id
    private String numero;
    private boolean credito;
    private Date validade;
    private String codigoValidacao;

    public Cartao( boolean credito, Date validade, String numero, String codigoValidacao )
    {
        this.credito = credito;
        this.validade = validade;
        this.numero = numero;
        this.codigoValidacao = codigoValidacao;
    }

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
