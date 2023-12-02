package com.BancoFoda.BancoFoda.model.service.monetario.movimentacao;

import com.BancoFoda.BancoFoda.exceptions.MovimentacaoNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.*;
import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Transferencia;
import com.BancoFoda.BancoFoda.model.repository.monetario.movimentacao.TransferenciaRepository;
import com.BancoFoda.BancoFoda.model.service.ContaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
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

        contaOrigem.addTransferenciasEnviadas( transferencia );
        contaDestino.addTransferenciasRecebidas( transferencia );

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
        return _transferenciaRepository.save(transferencia);
    }

    public void deleteById(int id) throws MovimentacaoNotFoundException
    {
        if(!_transferenciaRepository.existsById(id)){
            throw new MovimentacaoNotFoundException(id);
        }

        _transferenciaRepository.deleteById(id);
    }

    public List<Transferencia> filtrar( Map<String, String> filtros)
    {
        if(filtros.containsKey( "data" )) return _transferenciaRepository.getTransferenciaFilteredByDate( filtros.get( "data" ) );

        return _transferenciaRepository.findAll();
    }
}
