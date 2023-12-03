package com.BancoFoda.BancoFoda.model.domain.conta;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fatura
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @PositiveOrZero
    private float valor;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Future
    private LocalDate dataVencimento;

    @NotNull
    private boolean pago;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartao_id")
    @OnDelete( action = OnDeleteAction.CASCADE)
    private Cartao cartao;
}
