package com.BancoFoda.BancoFoda.model.service;

import com.BancoFoda.BancoFoda.exceptions.CreditoNotFoundExcpetion;
import com.BancoFoda.BancoFoda.model.domain.Credito;
import com.BancoFoda.BancoFoda.model.repository.CreditoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditoService
{
    private final CreditoRepository _creditoRepository;

    public CreditoService( CreditoRepository creditoRepository )
    {
        _creditoRepository = creditoRepository;
    }

    public Credito save( Credito credito){
        return _creditoRepository.save(credito);
    }

    public List<Credito> list(){
        return _creditoRepository.findAll();
    }

    public Credito getById(int id) throws CreditoNotFoundExcpetion{
        Optional<Credito> opt = _creditoRepository.findById(id);

        if( opt.isEmpty() ){
            throw new CreditoNotFoundExcpetion(id);
        }
        return opt.get();
    }

    public Credito update(int id, Credito credito) throws CreditoNotFoundExcpetion{
        Credito creditoAux = this.getById(id);

        creditoAux.setValorTotal(credito.getValorTotal());
        creditoAux.setValorAtual(credito.getValorAtual());

        return _creditoRepository.save(creditoAux);
    }

    public void deleteById(int id) throws CreditoNotFoundExcpetion{
        if(!_creditoRepository.existsById(id)){
            throw new CreditoNotFoundExcpetion(id);
        }

        _creditoRepository.deleteById(id);
    }
}
