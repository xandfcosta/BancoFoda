package com.BancoFoda.BancoFoda.model.service;

import com.BancoFoda.BancoFoda.exceptions.ClienteNotFoundExcpetion;
import com.BancoFoda.BancoFoda.model.domain.*;
import com.BancoFoda.BancoFoda.model.repository.ClienteRepository;
import com.BancoFoda.BancoFoda.model.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClienteService
{
    private final ClienteRepository _clienteRepository;

    private final ContaRepository _contaRepository;

    public ClienteService( ClienteRepository clienteRepository, ContaRepository contaRepository )
    {
        _clienteRepository = clienteRepository;
        _contaRepository = contaRepository;
    }

    public Cliente save( Cliente cliente ){
        if(!Usuario.validarCPF(cliente.getCPF())) throw new Error("CPF invalido");
        Conta contaCliente = new Conta();

        contaCliente.setSaldo( 0 );
        contaCliente.setCartoes( new HashSet<Cartao>( ));
        contaCliente.setAgencia( 1 );
        contaCliente.setFaturas( new HashSet< Fatura >(  ) );

        _contaRepository.save( contaCliente );

        cliente.setConta( contaCliente );

        return _clienteRepository.save(cliente);
    }

    public List<Cliente> list(){
        return _clienteRepository.findAll();
    }

    public Cliente getById(String id) throws ClienteNotFoundExcpetion{
        Optional<Cliente> opt = _clienteRepository.findById(id);

        if( opt.isEmpty() ){
            throw new ClienteNotFoundExcpetion(id);
        }
        return opt.get();
    }

    public Cliente update(String id, Cliente cliente) throws ClienteNotFoundExcpetion{
        Cliente clienteAux = this.getById(id);

        clienteAux.setNomeCompleto(cliente.getNomeCompleto());
        clienteAux.setEmail(cliente.getEmail());
        clienteAux.setDataNascimento(cliente.getDataNascimento());
        clienteAux.setReceitaMensal(cliente.getReceitaMensal());
        clienteAux.setSenha(cliente.getSenha());

        return _clienteRepository.save(clienteAux);
    }

    public void deleteById(String id) throws ClienteNotFoundExcpetion{
        if(!_clienteRepository.existsById(id)){
            throw new ClienteNotFoundExcpetion(id);
        }

        _clienteRepository.deleteById(id);
    }
}
