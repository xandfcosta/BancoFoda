package com.BancoFoda.BancoFoda.model.domain;

import com.BancoFoda.BancoFoda.model.domain.monetario.pagamento.Pagamento;
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
    @OneToMany(cascade = CascadeType.ALL)
    private Set< Pagamento > pagamentos;

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

    public Set< Pagamento > getPagamentos( )
    {
        return pagamentos;
    }

    public void setPagamentos( Set< Pagamento > pagamentos )
    {
        this.pagamentos = pagamentos;
    }
}
