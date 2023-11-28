package com.BancoFoda.BancoFoda.model.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Fatura
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private float valor;
    private LocalDate vencimento;
    private LocalDate dataPagamento;
    @OneToMany
    @JoinColumn(name="fatura_id")
    private Set< Compra > compras;

    public Fatura( )
    {
    }

    public Set<Compra> getCompras() {
        return compras;
    }

    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
    }

    public int getId( ) { return id; }

    public void setId( int id ) { this.id = id; }

    public float getValor( )
    {
        return valor;
    }

    public void setValor( float valor )
    {
        this.valor = valor;
    }

    public LocalDate getVencimento( )
    {
        return vencimento;
    }

    public void setVencimento( LocalDate vencimento )
    {
        this.vencimento = vencimento;
    }

    public LocalDate getDataPagamento( )
    {
        return dataPagamento;
    }

    public void setDataPagamento( LocalDate dataPagamento )
    {
        this.dataPagamento = dataPagamento;
    }
}
