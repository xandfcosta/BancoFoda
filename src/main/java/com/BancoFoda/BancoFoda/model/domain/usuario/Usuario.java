package com.BancoFoda.BancoFoda.model.domain.usuario;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
            digito = Integer.parseInt(str.substring(indice,indice+1));
            soma += digito*peso[peso.length-str.length()+indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }
    public static boolean validarCPF(String cpf) {
        if ((cpf==null) || (cpf.length()!=11)) return false;

        int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        int digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
        int digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0,9) + digito1 + digito2);
    }
}
