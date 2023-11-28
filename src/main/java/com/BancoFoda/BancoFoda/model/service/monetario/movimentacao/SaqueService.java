package com.BancoFoda.BancoFoda.model.service.monetario.movimentacao;

import com.BancoFoda.BancoFoda.exceptions.MovimentacaoNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Saque;
import com.BancoFoda.BancoFoda.model.repository.monetario.movimentacao.SaqueRepository;
import com.BancoFoda.BancoFoda.model.service.ContaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SaqueService
{
    private final SaqueRepository _saqueRepository;
    private final ContaService _contaService;

    public SaqueService( SaqueRepository saqueRepository, ContaService contaService )
    {
        _saqueRepository = saqueRepository;
        _contaService = contaService;
    }

    public Saque save( Saque saque )
    {
        saque.setData( LocalDate.now() );

        Conta conta = _contaService.getById( saque.getConta().getNumero() );

        if(conta.getSaldo() <= 0) throw new Error("Saldo insuficiente para realizar o saque");

        conta.setSaldo( conta.getSaldo() - saque.getValor() );

        _contaService.update( conta.getNumero(), conta );

        return _saqueRepository.save(saque);
    }

    public List<Saque> list(){
        return _saqueRepository.findAll();
    }

    public Saque getById(int id) throws MovimentacaoNotFoundException
    {
        Optional<Saque> opt = _saqueRepository.findById(id);

        if( opt.isEmpty() ){
            throw new MovimentacaoNotFoundException(id);
        }
        return opt.get();
    }

    public Saque update(int id, Saque saque) throws MovimentacaoNotFoundException
    {
        Saque saqueAux = this.getById(id);

        saqueAux.setValor(saque.getValor());
        saqueAux.setData(saque.getData());


        return _saqueRepository.save(saqueAux);
    }

    public void deleteById(int id) throws MovimentacaoNotFoundException
    {
        if(!_saqueRepository.existsById(id)){
            throw new MovimentacaoNotFoundException(id);
        }

        _saqueRepository.deleteById(id);
    }
}
