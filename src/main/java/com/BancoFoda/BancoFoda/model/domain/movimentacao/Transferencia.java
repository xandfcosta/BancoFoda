package com.BancoFoda.BancoFoda.model.domain.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.conta.Conta;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@DiscriminatorValue( value = "transferencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transferencia extends Movimentacao
{
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "conta_origem_id", nullable = true)
    @OnDelete( action = OnDeleteAction.SET_NULL)
    @JsonBackReference
    private Conta origem;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "conta_destino_id", nullable = true)
    @OnDelete( action = OnDeleteAction.SET_NULL)
    @JsonBackReference
    private Conta destino;
}
