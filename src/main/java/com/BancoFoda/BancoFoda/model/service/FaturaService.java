package com.BancoFoda.BancoFoda.model.service;

import com.BancoFoda.BancoFoda.exceptions.FaturaNotFoundExcpetion;
import com.BancoFoda.BancoFoda.model.domain.Fatura;
import com.BancoFoda.BancoFoda.model.repository.FaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaturaService
{
    private final FaturaRepository _faturaRepository;

    public FaturaService( FaturaRepository faturaRepository )
    {
        _faturaRepository = faturaRepository;
    }

    public Fatura save( Fatura fatura){
        return _faturaRepository.save(fatura);
    }

    public List<Fatura> list(){
        return _faturaRepository.findAll();
    }

    public Fatura getById(int id) throws FaturaNotFoundExcpetion{
        Optional<Fatura> opt = _faturaRepository.findById(id);

        if( opt.isEmpty() ){
            throw new FaturaNotFoundExcpetion(id);
        }
        return opt.get();
    }

    public Fatura update(int id, Fatura fatura) throws FaturaNotFoundExcpetion{
        Fatura faturaAux = this.getById(id);

        faturaAux.setValor(fatura.getValor());
        faturaAux.setVencimento(fatura.getVencimento());
        faturaAux.setDataPagamento(fatura.getDataPagamento());

        return _faturaRepository.save(faturaAux);
    }

    public void deleteById(int id) throws FaturaNotFoundExcpetion{
        if(!_faturaRepository.existsById(id)){
            throw new FaturaNotFoundExcpetion(id);
        }

        _faturaRepository.deleteById(id);
    }
}
