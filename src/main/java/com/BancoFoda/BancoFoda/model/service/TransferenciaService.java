package com.BancoFoda.BancoFoda.model.service;

import com.BancoFoda.BancoFoda.exceptions.TransferenciaNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.*;
import com.BancoFoda.BancoFoda.model.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService
{
    private final TransferenciaRepository _transferenciaRepository;
    private final ContaService _contaService;

    public TransferenciaService( TransferenciaRepository transferenciaRepository, ContaService contaService )
    {
        _transferenciaRepository = transferenciaRepository;
        _contaService = contaService;
    }

    public Transferencia save( Transferencia transferencia )
    {
        if( transferencia.getOrigem() == null && transferencia.getDestino() != null ){
            Conta contaDeposito = _contaService.getById( transferencia.getDestino().getNumero() );
            contaDeposito.setSaldo( contaDeposito.getSaldo() + transferencia.getValor() );

            _contaService.update(contaDeposito.getNumero(), contaDeposito);
        }
        else if ( transferencia.getOrigem() != null && transferencia.getDestino() == null )
        {
            Conta contaSaque = _contaService.getById( transferencia.getOrigem().getNumero() );

            if(contaSaque.getSaldo() < transferencia.getValor())
            {
                throw new Error( "Conta não tem saldo suficiente para saque" );
            }

            contaSaque.setSaldo( contaSaque.getSaldo() - transferencia.getValor() );
            _contaService.update(contaSaque.getNumero(), contaSaque);
        }
        else
        {
            Conta contaOrigem = _contaService.getById( transferencia.getOrigem().getNumero() );
            Conta contaDestino = _contaService.getById( transferencia.getDestino().getNumero() );

            if(contaOrigem.getSaldo() < transferencia.getValor())
            {
                throw new Error( "Conta origem não tem saldo suficiente para realizar transferência" );
            }

            contaOrigem.setSaldo( contaOrigem.getSaldo() - transferencia.getValor() );
            contaDestino.setSaldo( contaDestino.getSaldo() + transferencia.getValor() );

            _contaService.update(contaOrigem.getNumero(), contaOrigem);
            _contaService.update(contaDestino.getNumero(), contaDestino);
        }

        transferencia.setData( new Date(  ) );

        return _transferenciaRepository.save(transferencia);
    }

    public List<Transferencia> list(){
        return _transferenciaRepository.findAll();
    }

    public Transferencia getById(String id) throws TransferenciaNotFoundException {
        Optional<Transferencia> opt = _transferenciaRepository.findById(id);

        if( opt.isEmpty() ){
            throw new TransferenciaNotFoundException(id);
        }
        return opt.get();
    }

    public Transferencia update(String id, Transferencia transferencia) throws TransferenciaNotFoundException {
        Transferencia transferenciaAux = this.getById(id);

        transferenciaAux.setValor(transferencia.getValor());
        transferenciaAux.setData(transferencia.getData());
        transferenciaAux.setOrigem(transferencia.getOrigem());
        transferenciaAux.setDestino(transferencia.getOrigem());


        return _transferenciaRepository.save(transferenciaAux);
    }

    public void deleteById(String id) throws TransferenciaNotFoundException {
        if(!_transferenciaRepository.existsById(id)){
            throw new TransferenciaNotFoundException(id);
        }

        _transferenciaRepository.deleteById(id);
    }
}
