package com.BancoFoda.BancoFoda.domain.model;

import java.util.ArrayList;

@Entity
public class Conta
{
    private String numero;
    private String agencia;
    private float salario;
    private ArrayList< Cartao > cartoes;

    public Conta( String numero, String agencia, float salario, ArrayList< Cartao > cartoes )
    {
        this.numero = numero;
        this.agencia = agencia;
        this.salario = salario;
        this.cartoes = cartoes;
    }

    public String getNumero( )
    {
        return numero;
    }

    public void setNumero( String numero )
    {
        this.numero = numero;
    }

    public String getAgencia( )
    {
        return agencia;
    }

    public void setAgencia( String agencia )
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

    public ArrayList< Cartao > getCartoes( )
    {
        return cartoes;
    }

    public void setCartoes( ArrayList< Cartao > cartoes )
    {
        this.cartoes = cartoes;
    }
}
