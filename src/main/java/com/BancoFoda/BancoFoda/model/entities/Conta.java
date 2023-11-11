package com.BancoFoda.BancoFoda.model.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Conta
{
    @Id
    private int numero;
    private int agencia;
    private float salario;
    @OneToMany
    @JoinColumn(name="cartao_id")
    private Set< Cartao > cartoes;

    public Conta( int numero, int agencia, float salario, Set< Cartao > cartoes )
    {
        this.numero = numero;
        this.agencia = agencia;
        this.salario = salario;
        this.cartoes = cartoes;
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

    public float getSalario( )
    {
        return salario;
    }

    public void setSalario( float salario )
    {
        this.salario = salario;
    }

    public Set< Cartao > getCartoes( )
    {
        return cartoes;
    }

    public void setCartoes( Set< Cartao > cartoes )
    {
        this.cartoes = cartoes;
    }
}
