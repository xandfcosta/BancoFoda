package com.BancoFoda.BancoFoda.model.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "tipo_usuario")
public class Usuario
{
    @Id
    private String CPF;
    private String nomeCompleto;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private float receitaMensal;
    private String senha;

    public Usuario( )
    {
    }

    public String getNomeCompleto( )
    {
        return nomeCompleto;
    }

    public void setNomeCompleto( String nomeCompleto )
    {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCPF( )
    {
        return CPF;
    }

    public void setCPF( String CPF )
    {
        this.CPF = CPF;
    }

    public String getEmail( )
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public Date getDataNascimento( )
    {
        return dataNascimento;
    }

    public void setDataNascimento( Date dataNascimento )
    {
        this.dataNascimento = dataNascimento;
    }

    public float getReceitaMensal( )
    {
        return receitaMensal;
    }

    public void setReceitaMensal( float receitaMensal )
    {
        this.receitaMensal = receitaMensal;
    }

    public String getSenha( )
    {
        return senha;
    }

    public void setSenha( String senha )
    {
        this.senha = senha;
    }
}
