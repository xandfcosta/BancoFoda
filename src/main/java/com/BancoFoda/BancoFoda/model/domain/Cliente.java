package com.BancoFoda.BancoFoda.model.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue(value="cliente")
public class Cliente extends Usuario
{
    @OneToOne
    private Conta conta;

    public Cliente( )
    {
    }

    public Conta getConta( ) { return conta; }

    public void setConta( Conta conta ) { this.conta = conta; }
}
