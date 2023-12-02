package com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@DiscriminatorValue( value = "transferencia")
public class Transferencia extends Movimentacao
{
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "conta_origem_id", nullable = true)
    @JsonBackReference
    private Conta origem;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "conta_destino_id", nullable = true)
    @JsonBackReference
    private Conta destino;

    public Transferencia( )
    {
    }

    public Conta getOrigem( )
    {
        return origem;
    }

    public void setOrigem( Conta origem )
    {
        this.origem = origem;
    }

    public Conta getDestino( )
    {
        return destino;
    }

    public void setDestino( Conta destino )
    {
        this.destino = destino;
    }
}
