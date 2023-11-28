package com.BancoFoda.BancoFoda.model.service.monetario.movimentacao;

import com.BancoFoda.BancoFoda.exceptions.MovimentacaoNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Deposito;
import com.BancoFoda.BancoFoda.model.repository.monetario.movimentacao.DepositoRepository;
import com.BancoFoda.BancoFoda.model.service.ContaService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        // TODO

        deposito.setData( new Date(  ) );

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
