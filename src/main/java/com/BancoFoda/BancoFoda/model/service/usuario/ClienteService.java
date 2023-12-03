package com.BancoFoda.BancoFoda.model.service.usuario;

import com.BancoFoda.BancoFoda.exceptions.UsuarioNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.usuario.Cliente;
import com.BancoFoda.BancoFoda.model.domain.usuario.Usuario;
import com.BancoFoda.BancoFoda.model.dtos.usuario.ClienteDTO;
import com.BancoFoda.BancoFoda.model.repository.usuario.ClienteRepository;
import com.BancoFoda.BancoFoda.model.service.conta.ContaService;
import com.BancoFoda.BancoFoda.model.service.movimentacao.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService
{
    @Autowired
    private ContaService _contaService;
    @Autowired
    private TransferenciaService _trasnferenciaService;
    @Autowired
    private ClienteRepository _clienteRepository;

    public Cliente save( ClienteDTO cliente ){
        if(!Usuario.validarCPF(cliente.cpf())) throw new Error("CPF invalido");
        LocalDate dataNascimento = LocalDate.parse(cliente.dataNascimento());
        if(!Usuario.maiorDeIdade( dataNascimento) ) throw new Error("Menor de idade");

        Cliente novoCliente = new Cliente( );
        novoCliente.setCPF( cliente.cpf() );
        novoCliente.setNomeCompleto( cliente.nomeCompleto() );
        novoCliente.setEmail( cliente.email() );
        novoCliente.setReceitaMensal( cliente.receitaMensal() );
        novoCliente.setDataNascimento( dataNascimento );
        novoCliente.setSenha( cliente.senha() );

        novoCliente.setConta( _contaService.criarNovaConta( cliente.receitaMensal() ) );

        return _clienteRepository.save(novoCliente);
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
