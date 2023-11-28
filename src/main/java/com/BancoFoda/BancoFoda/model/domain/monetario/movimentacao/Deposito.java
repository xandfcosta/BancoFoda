package com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue( value = "deposito")
public class Deposito extends Movimentacao
{
    @ManyToOne
    private Conta conta;

    public Deposito( )
    {
    }

    public Conta getConta( )
    {
        return conta;
    }

    public void setConta( Conta conta )
    {
        this.conta = conta;
    }
}
