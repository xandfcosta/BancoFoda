package com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

@Entity
@DiscriminatorValue( value = "deposito")
public class Deposito extends Movimentacao
{
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "conta_id", nullable = true)
    @JsonBackReference
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
