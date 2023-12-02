package com.BancoFoda.BancoFoda.model.domain.monetario.pagamento;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pagamento")
public class Pagamento
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Null
    private LocalDate data;
    @NotNull
    @Positive
    private float valor;
    private String descricao;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "conta_id", nullable = true)
    @JsonBackReference
    private Conta conta;

    public Pagamento()
    {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Conta getConta( )
    {
        return conta;
    }

    public void setConta( Conta conta )
    {
        this.conta = conta;
    }
}
