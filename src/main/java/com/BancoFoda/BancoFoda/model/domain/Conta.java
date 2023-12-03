package com.BancoFoda.BancoFoda.model.domain;

import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Transferencia;
import com.BancoFoda.BancoFoda.model.domain.usuario.Cliente;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private int numero;

    @NotNull
    private int agencia;

    @NotNull
    private float saldo;

    @OneToOne(mappedBy = "conta")
    private Cliente cliente;
}
