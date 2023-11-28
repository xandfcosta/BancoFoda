package com.BancoFoda.BancoFoda.model.service.monetario.pagamento;

import com.BancoFoda.BancoFoda.exceptions.PagamentoNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.BancoFoda.BancoFoda.model.domain.monetario.pagamento.Pagamento;
import com.BancoFoda.BancoFoda.model.domain.monetario.pagamento.PagamentoDebito;
import com.BancoFoda.BancoFoda.model.repository.monetario.pagamento.PagamentoDebitoRepository;
import com.BancoFoda.BancoFoda.model.service.ContaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PagamentoDebitoService
{
    private final PagamentoDebitoRepository _pagamentoDebitoRepository;
    private final ContaService _contaService;

    public PagamentoDebitoService( PagamentoDebitoRepository pagamentoDebitoRepository, ContaService contaService) {
        _pagamentoDebitoRepository = pagamentoDebitoRepository;
        _contaService = contaService;
    }

    public PagamentoDebito save( int numeroConta, PagamentoDebito pagamento ){
        pagamento.setData( LocalDate.now() );

        Conta conta = _contaService.getById( numeroConta );

        if(conta.getSaldo() <= 0 ) throw new Error("Saldo insuficiente para realizar pagamento");

        Set< Pagamento > pagamentos = conta.getPagamentos();
        pagamentos.add(pagamento);
        conta.setPagamentos( pagamentos );
        conta.setSaldo( pagamento.getValor() );

        _contaService.update( conta.getNumero(), conta );

        return _pagamentoDebitoRepository.save(pagamento);
    }

    public List< PagamentoDebito > list(){
        return _pagamentoDebitoRepository.findAll();
    }

    public PagamentoDebito getById( int id) throws PagamentoNotFoundException
    {
        Optional< PagamentoDebito > opt = _pagamentoDebitoRepository.findById(id);

        if( opt.isEmpty() ){
            throw new PagamentoNotFoundException(id);
        }
        return opt.get();
    }

    public PagamentoDebito update( int id, PagamentoDebito pagamento) throws PagamentoNotFoundException {
        PagamentoDebito pagamentoAux = this.getById(id);

        pagamentoAux.setData(pagamento.getData());
        pagamentoAux.setDescricao(pagamento.getDescricao());
        pagamentoAux.setValor(pagamento.getValor());

        return _pagamentoDebitoRepository.save(pagamentoAux);
    }

    public void deleteById(int id) throws PagamentoNotFoundException {
        if(!_pagamentoDebitoRepository.existsById(id)){
            throw new PagamentoNotFoundException(id);
        }

        _pagamentoDebitoRepository.deleteById(id);
    }
}
