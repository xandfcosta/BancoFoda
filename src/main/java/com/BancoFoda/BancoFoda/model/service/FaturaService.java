package com.BancoFoda.BancoFoda.model.service;

import com.BancoFoda.BancoFoda.exceptions.FaturaNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.Compra;
import com.BancoFoda.BancoFoda.model.domain.Fatura;
import com.BancoFoda.BancoFoda.model.repository.CompraRepository;
import com.BancoFoda.BancoFoda.model.repository.FaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaturaService
{
    private final FaturaRepository _faturaRepository;
    private final CompraRepository _compraRepository;

    public FaturaService(FaturaRepository faturaRepository, CompraRepository compraRepository )
    {
        _faturaRepository = faturaRepository;
        _compraRepository = compraRepository;
    }

    public Fatura save( Fatura fatura){
        return _faturaRepository.save(fatura);
    }

    public List<Fatura> list(){
        return _faturaRepository.findAll();
    }

    public Fatura getById(int id) throws FaturaNotFoundException {
        Optional<Fatura> opt = _faturaRepository.findById(id);

        if( opt.isEmpty() ){
            throw new FaturaNotFoundException(id);
        }
        return opt.get();
    }

    public Fatura update(int id, Fatura fatura) throws FaturaNotFoundException {
        Fatura faturaAux = this.getById(id);

        faturaAux.setValor(fatura.getValor());
        faturaAux.setVencimento(fatura.getVencimento());
        faturaAux.setDataPagamento(fatura.getDataPagamento());

        return _faturaRepository.save(faturaAux);
    }

    public void deleteById(int id) throws FaturaNotFoundException {
        if(!_faturaRepository.existsById(id)){
            throw new FaturaNotFoundException(id);
        }

        _faturaRepository.deleteById(id);
    }
}
