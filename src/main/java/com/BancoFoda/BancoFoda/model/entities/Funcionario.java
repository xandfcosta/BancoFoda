package com.BancoFoda.BancoFoda.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue(value="funcionario")
public class Funcionario extends Usuario
{
    private String setor;
    private String cargo;
    private float salario;

    public Funcionario( String CPF, String nomeCompleto, String email, Date dataNascimento, float receitaMensal, String senha, int id, String setor, String cargo, float salario )
    {
        super( CPF, nomeCompleto, email, dataNascimento, receitaMensal, senha );
        this.setor = setor;
        this.cargo = cargo;
        this.salario = salario;
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
