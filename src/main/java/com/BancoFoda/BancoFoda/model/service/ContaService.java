package com.BancoFoda.BancoFoda.model.service;

import com.BancoFoda.BancoFoda.exceptions.ContaNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Transferencia;
import com.BancoFoda.BancoFoda.model.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ContaService
{
    private final ContaRepository _contaRepository;

    public ContaService( ContaRepository contaRepository )
    {
        _contaRepository = contaRepository;
    }

    public Conta save( Conta conta ){
        return _contaRepository.save(conta);
    }

    public List<Conta> list(){
        return _contaRepository.findAll();
    }

    public Conta getById(int id) throws ContaNotFoundException {
        Optional<Conta> opt = _contaRepository.findById(id);

        if( opt.isEmpty() ){
            throw new ContaNotFoundException(id);
        }
        return opt.get();
    }

    public Conta update(int id, Conta conta) throws ContaNotFoundException {
        Conta contaAux = this.getById(id);

        contaAux.setAgencia( conta.getAgencia() );
        contaAux.setSaldo( conta.getSaldo() );
        contaAux.setDepositos( conta.getDepositos() );
        contaAux.setTransferenciasEnviadas( conta.getTransferenciasEnviadas() );
        contaAux.setTransferenciasRecebidas( conta.getTransferenciasRecebidas() );
        contaAux.setSaques( conta.getSaques() );
        contaAux.setPagamentos( conta.getPagamentos() );

        return _contaRepository.save(contaAux);
    }

    public void deleteById(int id) throws ContaNotFoundException {
        if(!_contaRepository.existsById(id)){
            throw new ContaNotFoundException(id);
        }

        Conta conta = this.getById( id );

        for(var deposito : conta.getDepositos())
        {
            conta.removeDepositos( deposito );
        }

        for(var saque : conta.getSaques())
        {
            conta.removeSaques( saque );
        }

        for(var pagamento : conta.getPagamentos())
        {
            conta.removePagamentos( pagamento );
        }

        for(var transferencia : conta.getTransferenciasEnviadas())
        {
            conta.removeTransferenciasEnviadas( transferencia );
        }

        for(var transferencia : conta.getTransferenciasRecebidas())
        {
            conta.removeTransferenciasRecebidas( transferencia );
        }

        _contaRepository.deleteById(id);
    }

    public List<Conta> filtrar( Map<String, String> filtros)
    {
        if(filtros.containsKey( "saldo" )) return _contaRepository.findUserFilteredBySaldo( filtros.get( ("saldo") ) );

        return _contaRepository.findAll();
    }
}
