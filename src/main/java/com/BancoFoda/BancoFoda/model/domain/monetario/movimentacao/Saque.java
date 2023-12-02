package com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@DiscriminatorValue( value = "saque")
public class Saque extends Movimentacao
{
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "conta_id", nullable = true)
    private Conta conta;

    public Saque( )
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
