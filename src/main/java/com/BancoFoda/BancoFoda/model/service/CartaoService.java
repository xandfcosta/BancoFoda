package com.BancoFoda.BancoFoda.model.service;

import com.BancoFoda.BancoFoda.exceptions.CartaoNotFoundExcpetion;
import com.BancoFoda.BancoFoda.model.domain.Cartao;
import com.BancoFoda.BancoFoda.model.repository.CartaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaoService
{
    private final CartaoRepository _cartaoRepository;

    public CartaoService( CartaoRepository cartaoRepository )
    {
        _cartaoRepository = cartaoRepository;
    }

    public Cartao save( Cartao cartao){
        return _cartaoRepository.save(cartao);
    }

    public List<Cartao> list(){
        return _cartaoRepository.findAll();
    }

    public Cartao getById(String id) throws CartaoNotFoundExcpetion{
        Optional<Cartao> opt = _cartaoRepository.findById(id);

        if( opt.isEmpty() ){
            throw new CartaoNotFoundExcpetion(id);
        }
        return opt.get();
    }

    public Cartao update(String id, Cartao cartao) throws CartaoNotFoundExcpetion{
        Cartao cartaoAux = this.getById(id);

        cartaoAux.setCredito(cartao.isCredito());
        cartaoAux.setValidade(cartao.getValidade());
        cartaoAux.setCodigoValidacao(cartao.getCodigoValidacao());

        return _cartaoRepository.save(cartaoAux);
    }

    public void deleteById(String id) throws CartaoNotFoundExcpetion{
        if(!_cartaoRepository.existsById(id)){
            throw new CartaoNotFoundExcpetion(id);
        }

        _cartaoRepository.deleteById(id);
    }
}
