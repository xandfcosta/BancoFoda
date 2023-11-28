package com.BancoFoda.BancoFoda.model.service;

import com.BancoFoda.BancoFoda.exceptions.ContaNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.BancoFoda.BancoFoda.model.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ContaService
{
    private final ContaRepository _contaRepository;

    public ContaService( ContaRepository contaRepository )
    {
        _contaRepository = contaRepository;
    }

    public Conta save( Conta conta){
        return _contaRepository.save(conta);
    }

    public List<Conta> list(){
        return _contaRepository.findAll();
    }

    public Conta getById(int id) throws ContaNotFoundException {
        Optional<Conta> opt = _contaRepository.findById(id);

        if( opt.isEmpty() ){
            throw new ContaNotFoundException(id);
        }
        return opt.get();
    }

    public Conta update(int id, Conta conta) throws ContaNotFoundException {
        Conta contaAux = this.getById(id);

        contaAux.setAgencia(conta.getAgencia());
        contaAux.setCartoes(conta.getCartoes());

        return _contaRepository.save(contaAux);
    }

    public void deleteById(int id) throws ContaNotFoundException {
        if(!_contaRepository.existsById(id)){
            throw new ContaNotFoundException(id);
        }

        _contaRepository.deleteById(id);
    }

    public Conta criarCartao( Conta conta ) {
        Cartao cartao = new Cartao();
        cartao.setCreditoAtual(conta.getReceitaMensalUsuario() * 0.6f);
        cartao.setCreditoTotal(cartao.getCreditoAtual());
        cartao.setValidade(LocalDate.now().plusYears( 5));
        Random rand = new Random();
        cartao.setCodigoValidacao(Integer.toString(rand.nextInt(100, 999)));

        conta.getCartoes().add( cartao );
        return this.update(conta.getNumero(), conta);
    }
}
