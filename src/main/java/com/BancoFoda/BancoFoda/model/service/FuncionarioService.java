package com.BancoFoda.BancoFoda.model.service;

import com.BancoFoda.BancoFoda.exceptions.FuncionarioNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.Funcionario;
import com.BancoFoda.BancoFoda.model.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService
{
    private final FuncionarioRepository _funcionarioRepository;

    public FuncionarioService( FuncionarioRepository funcionarioRepository )
    {
        _funcionarioRepository = funcionarioRepository;
    }

    public Funcionario save( Funcionario funcionario){
        return _funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> list(){
        return _funcionarioRepository.findAll();
    }

    public Funcionario getById(String id) throws FuncionarioNotFoundException {
        Optional<Funcionario> opt = _funcionarioRepository.findById(id);

        if( opt.isEmpty() ){
            throw new FuncionarioNotFoundException(id);
        }
        return opt.get();
    }

    public Funcionario update(String id, Funcionario funcionario) throws FuncionarioNotFoundException {
        Funcionario funcionarioAux = this.getById(id);

        funcionarioAux.setNomeCompleto(funcionario.getNomeCompleto());
        funcionarioAux.setEmail(funcionario.getEmail());
        funcionarioAux.setDataNascimento(funcionario.getDataNascimento());
        funcionarioAux.setReceitaMensal(funcionario.getReceitaMensal());
        funcionarioAux.setSenha(funcionario.getSenha());

        return _funcionarioRepository.save(funcionarioAux);
    }

    public void deleteById(String id) throws FuncionarioNotFoundException {
        if(!_funcionarioRepository.existsById(id)){
            throw new FuncionarioNotFoundException(id);
        }

        _funcionarioRepository.deleteById(id);
    }
}
