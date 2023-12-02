package com.BancoFoda.BancoFoda.model.domain.usuario;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.BancoFoda.BancoFoda.model.domain.monetario.pagamento.Pagamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.util.Set;

@Entity
@DiscriminatorValue(value="cliente")
public class Cliente extends Usuario
{
    @OneToOne(mappedBy = "cliente")
    private Conta conta;

    public Cliente( )
    {
    }

    public Conta getConta( ) { return conta; }
    public void setConta( Conta conta ) { this.conta = conta; }
}
