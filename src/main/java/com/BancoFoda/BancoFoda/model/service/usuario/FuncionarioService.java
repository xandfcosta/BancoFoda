package com.BancoFoda.BancoFoda.model.service.usuario;

import com.BancoFoda.BancoFoda.exceptions.UsuarioNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.usuario.Funcionario;
import com.BancoFoda.BancoFoda.model.repository.usuario.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FuncionarioService
{
    private final FuncionarioRepository _funcionarioRepository;

    public FuncionarioService( FuncionarioRepository funcionarioRepository )
    {
        _funcionarioRepository = funcionarioRepository;
    }

    public Funcionario save( Funcionario funcionario ){
        return _funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> list(){
        return _funcionarioRepository.findAll();
    }

    public Funcionario getById(String id) throws UsuarioNotFoundException {
        Optional<Funcionario> opt = _funcionarioRepository.findById(id);

        if( opt.isEmpty() ){
            throw new UsuarioNotFoundException(id);
        }
        return opt.get();
    }

    public Funcionario update(String id, Funcionario funcionario) throws UsuarioNotFoundException {
        Funcionario funcionarioAux = this.getById(id);

        funcionarioAux.setCargo( funcionario.getCargo() );
        funcionarioAux.setSetor( funcionario.getSetor() );
        funcionarioAux.setSalario( funcionario.getSalario() );
        funcionarioAux.setEmail( funcionario.getEmail() );

        return _funcionarioRepository.save(funcionarioAux);
    }

    public void deleteById(String id) throws UsuarioNotFoundException {
        if(!_funcionarioRepository.existsById(id)){
            throw new UsuarioNotFoundException(id);
        }

        _funcionarioRepository.deleteById(id);
    }
}
