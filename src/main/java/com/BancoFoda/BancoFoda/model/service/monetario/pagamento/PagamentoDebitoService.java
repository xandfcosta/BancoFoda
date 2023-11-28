package com.BancoFoda.BancoFoda.model.service.monetario.pagamento;

import com.BancoFoda.BancoFoda.exceptions.PagamentoNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.monetario.pagamento.PagamentoDebito;
import com.BancoFoda.BancoFoda.model.repository.monetario.pagamento.PagamentoDebitoRepository;
import com.BancoFoda.BancoFoda.model.service.ContaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoDebitoService
{
    private final PagamentoDebitoRepository _pagamentoDebitoRepository;

    public PagamentoDebitoService( PagamentoDebitoRepository pagamentoDebitoRepository) {
        this._pagamentoDebitoRepository = pagamentoDebitoRepository;
    }

    public PagamentoDebito save( PagamentoDebito pagamento){
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
