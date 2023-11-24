package com.BancoFoda.BancoFoda.model.service;

import com.BancoFoda.BancoFoda.exceptions.TransferenciaNotFoundExcpetion;
import com.BancoFoda.BancoFoda.model.domain.Transferencia;
import com.BancoFoda.BancoFoda.model.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService
{
    private final TransferenciaRepository _transferenciaRepository;

    public TransferenciaService( TransferenciaRepository transferenciaRepository )
    {
        _transferenciaRepository = transferenciaRepository;
    }

    public Transferencia save( Transferencia transferencia){
        return _transferenciaRepository.save(transferencia);
    }

    public List<Transferencia> list(){
        return _transferenciaRepository.findAll();
    }

    public Transferencia getById(int id) throws TransferenciaNotFoundExcpetion{
        Optional<Transferencia> opt = _transferenciaRepository.findById(id);

        if( opt.isEmpty() ){
            throw new TransferenciaNotFoundExcpetion(id);
        }
        return opt.get();
    }

    public Transferencia update(int id, Transferencia transferencia) throws TransferenciaNotFoundExcpetion{
        Transferencia transferenciaAux = this.getById(id);

        transferenciaAux.setValor(transferencia.getValor());
        transferenciaAux.setData(transferencia.getData());
        transferenciaAux.setCredito(transferencia.isCredito());
        transferenciaAux.setValidada(transferencia.isValidada());
        transferenciaAux.setOrigem(transferencia.getOrigem());
        transferenciaAux.setDestino(transferencia.getOrigem());


        return _transferenciaRepository.save(transferenciaAux);
    }

    public void deleteById(int id) throws TransferenciaNotFoundExcpetion{
        if(!_transferenciaRepository.existsById(id)){
            throw new TransferenciaNotFoundExcpetion(id);
        }

        _transferenciaRepository.deleteById(id);
    }
}
