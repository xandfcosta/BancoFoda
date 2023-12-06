package com.BancoFoda.BancoFoda.model.domain.conta;

import com.BancoFoda.BancoFoda.model.domain.usuario.Cliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conta
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numero;

    @NotNull
    @Positive
    private int agencia;

    @NotNull
    @PositiveOrZero
    private float saldo;

    @OneToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cliente cliente;

    @NotNull
    @Positive
    private float creditoAtual;

    @NotNull
    @Positive
    private float creditoTotal;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "conta")
    private Set<Cartao> cartoes;
}
