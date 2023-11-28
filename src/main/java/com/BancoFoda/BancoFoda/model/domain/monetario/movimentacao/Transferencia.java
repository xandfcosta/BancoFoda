package com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue( value = "transferencia")
public class Transferencia extends Movimentacao
{
    @ManyToOne
    private Conta origem;
    @ManyToOne
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
