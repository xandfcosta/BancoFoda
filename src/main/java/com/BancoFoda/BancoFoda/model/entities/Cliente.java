package com.BancoFoda.BancoFoda.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue(value="cliente")
public class Cliente extends Usuario
{
    @OneToOne
    private Conta conta;

    public Cliente( String CPF, String nomeCompleto, String email, Date dataNascimento, float receitaMensal, String senha, Conta conta )
    {
        super( CPF, nomeCompleto, email, dataNascimento, receitaMensal, senha );
        this.conta = conta;
    }

    public Conta getConta( ) { return conta; }

    public void setConta( Conta conta ) { this.conta = conta; }
}
