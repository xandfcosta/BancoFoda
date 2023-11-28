package com.BancoFoda.BancoFoda.model.service;

import com.BancoFoda.BancoFoda.exceptions.CartaoNotFoundException;
import com.BancoFoda.BancoFoda.exceptions.CompraRecusadaException;
import com.BancoFoda.BancoFoda.model.domain.Cartao;
import com.BancoFoda.BancoFoda.model.domain.Compra;
import com.BancoFoda.BancoFoda.model.domain.Fatura;
import com.BancoFoda.BancoFoda.model.repository.CartaoRepository;
import com.BancoFoda.BancoFoda.model.repository.CompraRepository;
import com.BancoFoda.BancoFoda.model.repository.FaturaRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CartaoService
{
    private final CartaoRepository _cartaoRepository;
    private final FaturaRepository _faturaRepository;
    private final CompraRepository _compraRepository;

    public CartaoService(CartaoRepository cartaoRepository, FaturaRepository faturaRepository, CompraRepository compraRepository)
    {
        _cartaoRepository = cartaoRepository;
        _faturaRepository = faturaRepository;
        _compraRepository = compraRepository;
    }

    public Cartao save( Cartao cartao){
        return _cartaoRepository.save(cartao);
    }

    public List<Cartao> list(){
        return _cartaoRepository.findAll();
    }

    public Cartao getById(String id) throws CartaoNotFoundException {
        Optional<Cartao> opt = _cartaoRepository.findById(id);

        if( opt.isEmpty() ){
            throw new CartaoNotFoundException(id);
        }
        return opt.get();
    }

    public Cartao update(String id, Cartao cartao) throws CartaoNotFoundException {
        Cartao cartaoAux = this.getById(id);

        cartaoAux.setCreditoTotal(cartao.getCreditoTotal());
        cartaoAux.setFatura(cartao.getFatura());
        cartaoAux.setCreditoAtual(cartao.getCreditoAtual());
        cartaoAux.setValidade(cartao.getValidade());
        cartaoAux.setCodigoValidacao(cartao.getCodigoValidacao());

        return _cartaoRepository.save(cartaoAux);
    }

    public void deleteById(String id) throws CartaoNotFoundException {
        if(!_cartaoRepository.existsById(id)){
            throw new CartaoNotFoundException(id);
        }

        _cartaoRepository.deleteById(id);
    }

    public Cartao compraNova( String id, Compra compra ) throws CartaoNotFoundException {
        Cartao cartao = this.getById( id );

        if ( compra.getValor() > cartao.getCreditoAtual() )
            throw new CompraRecusadaException( id );
        else
            cartao.setCreditoAtual( cartao.getCreditoAtual() - compra.getValor() );

        _compraRepository.save( compra );

        Fatura fatura = cartao.getFatura();
        Set< Compra > compras = fatura.getCompras();
        compras.add( compra );
        fatura.setCompras( compras );

        _faturaRepository.save( fatura );

        return cartao;
    }
}
