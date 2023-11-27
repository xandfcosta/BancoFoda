package com.BancoFoda.BancoFoda.model.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Conta
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numero;
    private int agencia;
    private float saldo;
    @OneToMany
    @JoinColumn(name="conta_id")
    private Set< Cartao > cartoes;
    @OneToMany
    @JoinColumn(name="conta_id")
    private Set< Fatura > faturas;

    public Conta( )
    {
    }

    public int getNumero( )
    {
        return numero;
    }

    public void setNumero( int numero )
    {
        this.numero = numero;
    }

    public int getAgencia( )
    {
        return agencia;
    }

    public void setAgencia( int agencia )
    {
        this.agencia = agencia;
    }

    public float getSaldo( )
    {
        return saldo;
    }

    public void setSaldo( float saldo )
    {
        this.saldo = saldo;
    }

    public Set< Cartao > getCartoes( )
    {
        return cartoes;
    }

    public void setCartoes( Set< Cartao > cartoes )
    {
        this.cartoes = cartoes;
    }

    public Set< Fatura > getFaturas( ) { return faturas; }

    public void setFaturas( Set< Fatura > faturas ) { this.faturas = faturas; }
}
