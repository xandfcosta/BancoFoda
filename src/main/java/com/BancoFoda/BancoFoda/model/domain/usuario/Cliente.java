package com.BancoFoda.BancoFoda.model.domain.usuario;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.BancoFoda.BancoFoda.model.domain.monetario.pagamento.Pagamento;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@DiscriminatorValue(value="cliente")
public class Cliente extends Usuario
{
    @OneToOne(cascade = CascadeType.ALL)
    private Conta conta;

    public Cliente( )
    {
    }

    public Conta getConta( ) { return conta; }
    public void setConta( Conta conta ) { this.conta = conta; }
}
