package com.BancoFoda.BancoFoda.model;

import java.util.ArrayList;
import jakarta.persistence.*;

public class Conta
{
    private int numero;
    private int agencia;
    private float salario;
    private ArrayList< Cartao > cartoes;

    public Conta( int numero, int agencia, float salario, ArrayList< Cartao > cartoes )
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

    public ArrayList< Cartao > getCartoes( )
    {
        return cartoes;
    }

    public void setCartoes( ArrayList< Cartao > cartoes )
    {
        this.cartoes = cartoes;
    }
}
