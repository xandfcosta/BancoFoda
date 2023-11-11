package com.BancoFoda.BancoFoda.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Funcionario extends Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String setor;
    private String cargo;
    private float salario;

    public Funcionario( )
    {
        super();
    }

    public String getSetor( )
    {
        return setor;
    }

    public void setSetor( String setor )
    {
        this.setor = setor;
    }

    public String getCargo( )
    {
        return cargo;
    }

    public void setCargo( String cargo )
    {
        this.cargo = cargo;
    }

    public float getSalario( )
    {
        return salario;
    }

    public void setSalario( float salario )
    {
        this.salario = salario;
    }
}
