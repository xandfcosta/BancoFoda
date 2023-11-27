package com.BancoFoda.BancoFoda.model.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue(value="funcionario")
public class Funcionario extends Usuario
{
    private String setor;
    private String cargo;
    private float salario;

    public Funcionario( )
    {
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
