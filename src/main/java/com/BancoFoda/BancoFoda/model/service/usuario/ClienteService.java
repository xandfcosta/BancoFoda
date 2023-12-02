package com.BancoFoda.BancoFoda.model.service.usuario;

import com.BancoFoda.BancoFoda.exceptions.UsuarioNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.*;
import com.BancoFoda.BancoFoda.model.domain.usuario.Cliente;
import com.BancoFoda.BancoFoda.model.domain.usuario.Usuario;
import com.BancoFoda.BancoFoda.model.repository.usuario.ClienteRepository;
import com.BancoFoda.BancoFoda.model.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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

    public Cliente save( Cliente cliente ){
        if(!Usuario.validarCPF(cliente.getCPF())) throw new Error("CPF invalido");
        if(!Usuario.maiorDeIdade(cliente.getDataNascimento())) throw new Error("Menor de idade");

        Conta conta = new Conta();

        conta.setSaldo( 0 );
        conta.setAgencia( 1 );

        cliente.setConta( conta );

        return _clienteRepository.save(cliente);
    }

    public List<Cliente> list(){
        return _clienteRepository.findAll();
    }

    public Cliente getById(String id) throws UsuarioNotFoundException {
        Optional<Cliente> opt = _clienteRepository.findById(id);

        if( opt.isEmpty() ){
            throw new UsuarioNotFoundException(id);
        }
        return opt.get();
    }

    public Cliente update(String id, Cliente cliente) throws UsuarioNotFoundException {
        Cliente clienteAux = this.getById(id);

        clienteAux.setNomeCompleto(cliente.getNomeCompleto());
        clienteAux.setEmail(cliente.getEmail());
        clienteAux.setDataNascimento(cliente.getDataNascimento());
        clienteAux.setReceitaMensal(cliente.getReceitaMensal());
        clienteAux.setSenha(cliente.getSenha());

        return _clienteRepository.save(clienteAux);
    }

    public void deleteById(String id) throws UsuarioNotFoundException {
        if(!_clienteRepository.existsById(id)){
            throw new UsuarioNotFoundException(id);
        }

        _clienteRepository.deleteById(id);
    }
}
