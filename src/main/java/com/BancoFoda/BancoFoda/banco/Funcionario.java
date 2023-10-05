package com.BancoFoda.BancoFoda.banco;

import java.util.Date;

public class Funcionario extends Usuario
{
    private String setor;
    private String cargo;
    private float salario;

    public Funcionario( String nomeCompleto, String CPF, String email, Date dataNascimento, float receitaMensal, String senha, String setor, String cargo, float salario )
    {
        super( nomeCompleto, CPF, email, dataNascimento, receitaMensal, senha );
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
