package com.BancoFoda.BancoFoda.model.service.movimentacao;

import com.BancoFoda.BancoFoda.exceptions.MovimentacaoNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.conta.Conta;
import com.BancoFoda.BancoFoda.model.domain.movimentacao.Transferencia;
import com.BancoFoda.BancoFoda.model.dtos.movimentacao.TransferenciaDTO;
import com.BancoFoda.BancoFoda.model.repository.movimentacao.TransferenciaRepository;
import com.BancoFoda.BancoFoda.model.service.conta.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService
{
    @Autowired
    private ContaService _contaService;
    @Autowired
    private TransferenciaRepository _transferenciaRepository;

    public Transferencia save( TransferenciaDTO transferencia )
    {
        Conta contaOrigem = _contaService.findById( transferencia.origem() );
        Conta contaDestino = _contaService.findById( transferencia.destino() );

        if(contaOrigem.getSaldo() <= 0) throw new Error("Saldo insuficiente para realizar a transferencia");

        Transferencia novaTransferencia = new Transferencia( );
        novaTransferencia.setOrigem( contaOrigem );
        novaTransferencia.setDestino( contaDestino );
        novaTransferencia.setValor( transferencia.valor() );
        novaTransferencia.setData( LocalDate.now() );

        contaOrigem.setSaldo( contaOrigem.getSaldo() - transferencia.valor() );
        contaDestino.setSaldo( contaDestino.getSaldo() + transferencia.valor() );

        _contaService.save( contaOrigem );
        _contaService.save( contaDestino );

        return _transferenciaRepository.save(novaTransferencia);
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
}
