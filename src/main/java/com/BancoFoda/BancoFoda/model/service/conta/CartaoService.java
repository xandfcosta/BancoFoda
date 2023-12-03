package com.BancoFoda.BancoFoda.model.service.conta;

import com.BancoFoda.BancoFoda.exceptions.ContaNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.conta.Cartao;
import com.BancoFoda.BancoFoda.model.domain.conta.CartaoType;
import com.BancoFoda.BancoFoda.model.domain.conta.Conta;
import com.BancoFoda.BancoFoda.model.domain.conta.Fatura;
import com.BancoFoda.BancoFoda.model.repository.conta.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class CartaoService
{
    @Autowired
    private FaturaService _faturaService;
    @Autowired
    private CartaoRepository _cartaoRepository;
    
    public Cartao save( Cartao cartao ){
        return _cartaoRepository.save(cartao);
    }

    public List<Cartao> list(){
        return _cartaoRepository.findAll();
    }

    public Cartao findById(Long id) throws ContaNotFoundException {
        return _cartaoRepository.findById(id).orElseThrow(() -> new ContaNotFoundException(id));
    }

    public Cartao update(Long id, Cartao cartao) throws ContaNotFoundException {
        Cartao cartaoAux = this.findById(id);

        cartaoAux.setTipo( cartao.getTipo() );
        cartaoAux.setFaturas( cartao.getFaturas() );
        cartaoAux.setValidade( cartao.getValidade() );
        cartaoAux.setCodigoValidacao( cartao.getCodigoValidacao() );

        return _cartaoRepository.save(cartaoAux);
    }

    public void deleteById(Long id) throws ContaNotFoundException {
        if(!_cartaoRepository.existsById(id)){
            throw new ContaNotFoundException(id);
        }

        Cartao cartao = this.findById( id );

        _cartaoRepository.deleteById(id);
    }

    public Cartao criarCartaoNovo( Conta conta, CartaoType tipo )
    {
        Cartao cartao = new Cartao();
        cartao.setConta( conta );
        cartao.setCodigoValidacao( cartao.gerarCodigoValidacao() );
        cartao.setValidade( LocalDate.now( ).plusYears( 1 ) );
        cartao.setTipo( tipo );
        if(tipo == CartaoType.CREDITO)
        {
            return _faturaService.criarFaturaNova( cartao ).getCartao();
        }

        return this.save(cartao);
    }

    public List<Cartao> findVencendoHoje()
    {
        return _cartaoRepository.findByValidade( LocalDate.now().toString() ).orElseThrow(() -> new ContaNotFoundException( ));
    }
}
