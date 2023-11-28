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
    private float receitaMensalUsuario;

    public Conta( )
    {
    }

    public float getReceitaMensalUsuario() {
        return receitaMensalUsuario;
    }

    public void setReceitaMensalUsuario(float receitaMensalUsuario) {
        this.receitaMensalUsuario = receitaMensalUsuario;
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
}
