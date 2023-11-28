package com.BancoFoda.BancoFoda.model.service;

import com.BancoFoda.BancoFoda.exceptions.CompraNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.Compra;
import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.BancoFoda.BancoFoda.model.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
    private final CompraRepository _compraRepository;
    private final CartaoService _cartaoService;
    private final ContaService _contaService;

    public CompraService(CompraRepository compraRepository, CartaoService cartaoService, ContaService contaService) {
        this._compraRepository = compraRepository;
        this._cartaoService = cartaoService;
        this._contaService = contaService;
    }

    public Compra save(Compra compra){
        return _compraRepository.save(compra);
    }

    public List<Compra> list(){
        return _compraRepository.findAll();
    }

    public Compra getById(int id) throws CompraNotFoundException {
        Optional<Compra> opt = _compraRepository.findById(id);

        if( opt.isEmpty() ){
            throw new CompraNotFoundException(id);
        }
        return opt.get();
    }

    public Compra update(int id, Compra compra) throws CompraNotFoundException {
        Compra compraAux = this.getById(id);

        compraAux.setData(compra.getData());
        compraAux.setDescricao(compra.getDescricao());
        compraAux.setValor(compra.getValor());

        return _compraRepository.save(compraAux);
    }

    public void deleteById(int id) throws CompraNotFoundException {
        if(!_compraRepository.existsById(id)){
            throw new CompraNotFoundException(id);
        }

        _compraRepository.deleteById(id);
    }
}
