package com.BancoFoda.BancoFoda.model.service;

import com.BancoFoda.BancoFoda.exceptions.ContaNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.BancoFoda.BancoFoda.model.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ContaService
{
    @Autowired
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

    public Conta findById(int id) throws ContaNotFoundException {
        return  _contaRepository.findById(id).orElseThrow(() -> new ContaNotFoundException(id));
    }

    public Conta update(int id, Conta conta) throws ContaNotFoundException {
        Conta contaAux = this.findById(id);

        contaAux.setAgencia( conta.getAgencia() );
        contaAux.setSaldo( conta.getSaldo() );

        return _contaRepository.save(contaAux);
    }

    public void deleteById(int id) throws ContaNotFoundException {
        if(!_contaRepository.existsById(id)){
            throw new ContaNotFoundException(id);
        }

        Conta conta = this.findById( id );

        _contaRepository.deleteById(id);
    }

    public List<Conta> filtrar( Map<String, String> filtros)
    {
        return _contaRepository.findUserBySaldoGreaterThan( Float.parseFloat( filtros.get( "saldo" ) ) );
    }
}
