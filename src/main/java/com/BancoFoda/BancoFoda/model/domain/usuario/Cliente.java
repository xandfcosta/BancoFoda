package com.BancoFoda.BancoFoda.model.domain.usuario;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import jakarta.persistence.*;

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
