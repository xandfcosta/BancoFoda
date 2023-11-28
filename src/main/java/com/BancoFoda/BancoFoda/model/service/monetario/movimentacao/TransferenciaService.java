package com.BancoFoda.BancoFoda.model.service.monetario.movimentacao;

import com.BancoFoda.BancoFoda.exceptions.MovimentacaoNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.*;
import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Transferencia;
import com.BancoFoda.BancoFoda.model.repository.monetario.movimentacao.TransferenciaRepository;
import com.BancoFoda.BancoFoda.model.service.ContaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        transferencia.setData( LocalDate.now() );

        Conta contaOrigem = _contaService.getById( transferencia.getOrigem().getNumero() );

        if(contaOrigem.getSaldo() <= 0) throw new Error("Saldo insuficiente para realizar a transferencia");

        Conta contaDestino = _contaService.getById( transferencia.getDestino().getNumero() );

        contaOrigem.setSaldo( contaOrigem.getSaldo() - transferencia.getValor() );
        contaDestino.setSaldo( contaDestino.getSaldo() + transferencia.getValor() );

        _contaService.update( contaOrigem.getNumero(), contaOrigem);
        _contaService.update( contaDestino.getNumero(), contaDestino);

        return _transferenciaRepository.save(transferencia);
    }

    public List<Transferencia> list(){
        return _transferenciaRepository.findAll();
    }

    public Transferencia getById(int id) throws MovimentacaoNotFoundException
    {
        Optional<Transferencia> opt = _transferenciaRepository.findById(id);

        if( opt.isEmpty() ){
            throw new MovimentacaoNotFoundException(id);
        }
        return opt.get();
    }

    public Transferencia update(int id, Transferencia transferencia) throws MovimentacaoNotFoundException
    {
        Transferencia transferenciaAux = this.getById(id);

        transferenciaAux.setValor(transferencia.getValor());
        transferenciaAux.setData(transferencia.getData());
        transferenciaAux.setOrigem(transferencia.getOrigem());
        transferenciaAux.setDestino(transferencia.getOrigem());


        return _transferenciaRepository.save(transferenciaAux);
    }

    public void deleteById(int id) throws MovimentacaoNotFoundException
    {
        if(!_transferenciaRepository.existsById(id)){
            throw new MovimentacaoNotFoundException(id);
        }

        _transferenciaRepository.deleteById(id);
    }
}
