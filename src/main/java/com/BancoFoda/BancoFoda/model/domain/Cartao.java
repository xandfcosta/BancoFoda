package com.BancoFoda.BancoFoda.model.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Cartao
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String numero;
    private Date validade;
    private String codigoValidacao;
    private float creditoTotal;
    private float creditoAtual;
    @OneToOne
    @JoinColumn(name="cartao_id")
    private Fatura fatura;

    public Cartao( )
    {
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public float getCreditoTotal() {
        return creditoTotal;
    }

    public void setCreditoTotal(float creditoTotal) {
        this.creditoTotal = creditoTotal;
    }

    public float getCreditoAtual() {
        return creditoAtual;
    }

    public void setCreditoAtual(float creditoAtual) {
        this.creditoAtual = creditoAtual;
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
