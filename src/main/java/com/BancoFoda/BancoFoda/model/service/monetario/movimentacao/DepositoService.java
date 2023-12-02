package com.BancoFoda.BancoFoda.model.service.monetario.movimentacao;

import com.BancoFoda.BancoFoda.exceptions.MovimentacaoNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Deposito;
import com.BancoFoda.BancoFoda.model.repository.monetario.movimentacao.DepositoRepository;
import com.BancoFoda.BancoFoda.model.repository.monetario.movimentacao.SaqueRepository;
import com.BancoFoda.BancoFoda.model.service.ContaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class DepositoService
{
    private final DepositoRepository _depositoRepository;
    private final ContaService _contaService;

    public DepositoService( DepositoRepository depositoRepository, ContaService contaService )
    {
        _depositoRepository = depositoRepository;
        _contaService = contaService;
    }

    public Deposito save( Deposito deposito )
    {
        deposito.setData( LocalDate.now() );

        Conta conta = _contaService.getById( deposito.getConta().getNumero() );

        conta.addDepositos( deposito );

        return _depositoRepository.save(deposito);
    }

    public List<Deposito> list(){
        return _depositoRepository.findAll();
    }

    public Deposito getById(int id) throws MovimentacaoNotFoundException
    {
        Optional<Deposito> opt = _depositoRepository.findById(id);

        if( opt.isEmpty() ){
            throw new MovimentacaoNotFoundException(id);
        }
        return opt.get();
    }

    public Deposito update(int id, Deposito deposito) throws MovimentacaoNotFoundException
    {
        Deposito depositoAux = this.getById(id);

        depositoAux.setValor(deposito.getValor());
        depositoAux.setData(deposito.getData());


        return _depositoRepository.save(depositoAux);
    }

    public void deleteById(int id) throws MovimentacaoNotFoundException
    {
        if(!_depositoRepository.existsById(id)){
            throw new MovimentacaoNotFoundException(id);
        }

        _depositoRepository.deleteById(id);
    }
}
