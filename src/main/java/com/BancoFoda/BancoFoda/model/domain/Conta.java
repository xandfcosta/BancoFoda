package com.BancoFoda.BancoFoda.model.domain;

import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Deposito;
import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Movimentacao;
import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Saque;
import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Transferencia;
import com.BancoFoda.BancoFoda.model.domain.monetario.pagamento.Pagamento;
import com.BancoFoda.BancoFoda.model.domain.usuario.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Set;

@Entity
public class Conta
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numero;
    @NotNull
    private int agencia;
    @NotNull
    private float saldo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(mappedBy = "conta")
    @JsonManagedReference
    private Set< Pagamento > pagamentos;
    @OneToMany(mappedBy = "conta")
    @JsonManagedReference
    private Set< Saque > saques;
    @OneToMany(mappedBy = "conta")
    @JsonManagedReference
    private Set< Deposito > depositos;
    @OneToMany(mappedBy = "origem")
    @JsonManagedReference
    private Set< Transferencia > transferenciasEnviadas;
    @OneToMany(mappedBy = "destino")
    @JsonManagedReference
    private Set< Transferencia > transferenciasRecebidas;

    public Conta( )
    {
    }

    public int getNumero( )
    {
        return numero;
    }

    public void setNumero( int numero )
    {
        this.numero = numero;
    }

    public int getAgencia( )
    {
        return agencia;
    }

    public void setAgencia( int agencia )
    {
        this.agencia = agencia;
    }

    public float getSaldo( )
    {
        return saldo;
    }

    public void setSaldo( float saldo )
    {
        this.saldo = saldo;
    }

    public Set< Pagamento > getPagamentos( )
    {
        return pagamentos;
    }

    public void setPagamentos( Set< Pagamento > pagamentos )
    {
        this.pagamentos = pagamentos;
    }

    public void addPagamentos( Pagamento pagamento )
    {
        this.pagamentos.add(pagamento);
        pagamento.setConta( this );
    }

    public void removePagamentos( Pagamento pagamento )
    {
        this.pagamentos.remove(pagamento);
        pagamento.setConta( this );
    }

    public Cliente getCliente( )
    {
        return cliente;
    }

    public void setCliente( Cliente cliente )
    {
        this.cliente = cliente;
    }

    public Set< Saque > getSaques( )
    {
        return saques;
    }

    public void setSaques( Set< Saque > saques )
    {
        this.saques = saques;
    }

    public void addSaques( Saque saque )
    {
        this.saques.add(saque);
        this.saldo -= saque.getValor();
        saque.setConta( this );
    }

    public void removeSaques( Saque saque )
    {
        this.saques.remove(saque);
        saque.setConta( null );
    }

    public Set< Deposito > getDepositos( )
    {
        return depositos;
    }

    public void setDepositos( Set< Deposito > depositos )
    {
        this.depositos = depositos;
    }

    public void addDepositos( Deposito deposito )
    {
        this.depositos.add(deposito);
        this.saldo += deposito.getValor();
        deposito.setConta( this );
    }

    public void removeDepositos( Deposito deposito )
    {
        this.depositos.remove(deposito);
        deposito.setConta( null );
    }

    public Set< Transferencia > getTransferenciasEnviadas( )
    {
        return transferenciasEnviadas;
    }

    public void setTransferenciasEnviadas( Set< Transferencia > transferenciasEnviadas )
    {
        this.transferenciasEnviadas = transferenciasEnviadas;
    }

    public void addTransferenciasEnviadas( Transferencia transferencia )
    {
        this.transferenciasEnviadas.add(transferencia);
        this.saldo -= transferencia.getValor();
        transferencia.setOrigem( this );
    }

    public void removeTransferenciasEnviadas( Transferencia transferencia )
    {
        this.transferenciasEnviadas.remove(transferencia);
        transferencia.setOrigem( null );
    }

    public Set< Transferencia > getTransferenciasRecebidas( )
    {
        return transferenciasRecebidas;
    }

    public void setTransferenciasRecebidas( Set< Transferencia > transferenciasRecebidas )
    {
        this.transferenciasRecebidas = transferenciasRecebidas;
    }

    public void addTransferenciasRecebidas( Transferencia transferencia )
    {
        this.transferenciasRecebidas.add(transferencia);
        this.saldo += transferencia.getValor();
        transferencia.setDestino( this );
    }

    public void removeTransferenciasRecebidas( Transferencia transferencia )
    {
        this.transferenciasRecebidas.remove(transferencia);
        transferencia.setDestino( null );
    }
}
