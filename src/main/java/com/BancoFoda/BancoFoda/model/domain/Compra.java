package com.BancoFoda.BancoFoda.model.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private LocalDate data;
    private float valor;
    private String descricao;
    private boolean credito;

    public Compra()
    {
    }

    public boolean isCredito() {
        return credito;
    }

    public void setCredito(boolean credito) {
        this.credito = credito;
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
}
