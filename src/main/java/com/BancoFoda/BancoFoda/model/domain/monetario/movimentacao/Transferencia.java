package com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

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
