package com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_movimentacao")
public class Movimentacao
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private float valor;
    private Date data;

    public Movimentacao( )
    {
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

    public Date getData( )
    {
        return data;
    }

    public void setData( Date data )
    {
        this.data = data;
    }
}
