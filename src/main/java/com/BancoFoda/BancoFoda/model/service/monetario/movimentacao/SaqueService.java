package com.BancoFoda.BancoFoda.model.service.monetario.movimentacao;

import com.BancoFoda.BancoFoda.exceptions.MovimentacaoNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Saque;
import com.BancoFoda.BancoFoda.model.repository.monetario.movimentacao.SaqueRepository;
import com.BancoFoda.BancoFoda.model.service.ContaService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SaqueService
{
    private final SaqueRepository _saqueRepository;

    public SaqueService( SaqueRepository saqueRepository )
    {
        _saqueRepository = saqueRepository;
    }

    public Saque save( Saque saque )
    {
        // TODO

        saque.setData( new Date(  ) );

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
