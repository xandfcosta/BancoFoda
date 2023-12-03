package com.BancoFoda.BancoFoda.model.service.conta;

import com.BancoFoda.BancoFoda.exceptions.ContaNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.conta.Cartao;
import com.BancoFoda.BancoFoda.model.domain.conta.Fatura;
import com.BancoFoda.BancoFoda.model.repository.conta.FaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FaturaService
{
    @Autowired
    private FaturaRepository _faturaRepository;
    
    public Fatura save( Fatura fatura ){
        return _faturaRepository.save(fatura);
    }

    public List<Fatura> list(){
        return _faturaRepository.findAll();
    }

    public Fatura findById(Long id) throws ContaNotFoundException {
        return  _faturaRepository.findById(id).orElseThrow(() -> new ContaNotFoundException(id));
    }

    public Fatura update(Long id, Fatura fatura) throws ContaNotFoundException {
        Fatura faturaAux = this.findById(id);

        faturaAux.setCartao( fatura.getCartao() );
        faturaAux.setPago( fatura.isPago() );
        faturaAux.setValor( fatura.getValor() );
        faturaAux.setDataVencimento( fatura.getDataVencimento() );

        return _faturaRepository.save(faturaAux);
    }

    public void deleteById(Long id) throws ContaNotFoundException {
        if(!_faturaRepository.existsById(id)){
            throw new ContaNotFoundException(id);
        }

        Fatura fatura = this.findById( id );

        _faturaRepository.deleteById(id);
    }

    public Fatura criarFaturaNova( Cartao cartao )
    {
        Fatura fatura = new Fatura( );
        fatura.setDataVencimento( LocalDate.now().plusMonths( 1 ) );
        fatura.setPago( false );
        fatura.setCartao( cartao );
        fatura.setValor( 0 );

        return this.save( fatura );
    }

    public List<Fatura> findVencendoHoje()
    {
        return _faturaRepository.findByDataVencimento( LocalDate.now().toString() ).orElseThrow(() -> new ContaNotFoundException( ));
    }
}
