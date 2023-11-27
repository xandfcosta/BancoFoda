package com.BancoFoda.BancoFoda.model.service;

import com.BancoFoda.BancoFoda.exceptions.ClienteNotFoundExcpetion;
import com.BancoFoda.BancoFoda.model.domain.Cliente;
import com.BancoFoda.BancoFoda.model.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService
{
    private final ClienteRepository _clienteRepository;

    public ClienteService( ClienteRepository clienteRepository )
    {
        _clienteRepository = clienteRepository;
    }

    public Cliente save( Cliente cliente){
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
