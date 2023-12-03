package com.BancoFoda.BancoFoda.model.service.conta;

import com.BancoFoda.BancoFoda.exceptions.ContaNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.conta.Cartao;
import com.BancoFoda.BancoFoda.model.domain.conta.CartaoType;
import com.BancoFoda.BancoFoda.model.domain.conta.Conta;
import com.BancoFoda.BancoFoda.model.repository.conta.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ContaService
{
    @Autowired
    private CartaoService _cartaoService;
    @Autowired
    private ContaRepository _contaRepository;

    public Conta save( Conta conta ){
        return _contaRepository.save(conta);
    }

    public List<Conta> list(){
        return _contaRepository.findAll();
    }

    public Conta findById(Long id) throws ContaNotFoundException {
        return  _contaRepository.findById(id).orElseThrow(() -> new ContaNotFoundException(id));
    }

    public Conta update(Long id, Conta conta) throws ContaNotFoundException {
        Conta contaAux = this.findById(id);

        contaAux.setAgencia( conta.getAgencia() );
        contaAux.setSaldo( conta.getSaldo() );

        return _contaRepository.save(contaAux);
    }

    public void deleteById(Long id) throws ContaNotFoundException {
        if(!_contaRepository.existsById(id)){
            throw new ContaNotFoundException(id);
        }

        Conta conta = this.findById( id );

        _contaRepository.deleteById(id);
    }

    public Conta criarNovaConta(float receitaMensal)
    {
        Conta conta = new Conta();
        conta.setSaldo( 0 );
        conta.setAgencia( 1 );
        conta.setCreditoTotal( receitaMensal * 0.6f );
        conta.setCreditoAtual( conta.getCreditoTotal() );
        _cartaoService.criarCartaoNovo( conta, CartaoType.DEBITO );

        return _cartaoService.criarCartaoNovo( conta, CartaoType.CREDITO ).getConta();
    }
}
