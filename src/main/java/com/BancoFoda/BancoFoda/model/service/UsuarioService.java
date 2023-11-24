package com.BancoFoda.BancoFoda.model.service;

import com.BancoFoda.BancoFoda.exceptions.UsuarioNotFoundExcpetion;
import com.BancoFoda.BancoFoda.model.domain.Usuario;
import com.BancoFoda.BancoFoda.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService
{
    private final UsuarioRepository _usuarioRepository;

    public UsuarioService( UsuarioRepository usuarioRepository )
    {
        _usuarioRepository = usuarioRepository;
    }

    public Usuario save( Usuario usuario){
        return _usuarioRepository.save(usuario);
    }

    public List<Usuario> list(){
        return _usuarioRepository.findAll();
    }

    public Usuario getById(String id) throws UsuarioNotFoundExcpetion{
        Optional<Usuario> opt = _usuarioRepository.findById(id);

        if( opt.isEmpty() ){
            throw new UsuarioNotFoundExcpetion(id);
        }
        return opt.get();
    }

    public Usuario update(String id, Usuario usuario) throws UsuarioNotFoundExcpetion{
        Usuario usuarioAux = this.getById(id);

        usuarioAux.setNomeCompleto(usuario.getNomeCompleto());
        usuarioAux.setEmail(usuario.getEmail());
        usuarioAux.setDataNascimento(usuario.getDataNascimento());
        usuarioAux.setReceitaMensal(usuario.getReceitaMensal());
        usuarioAux.setSenha(usuario.getSenha());

        return _usuarioRepository.save(usuarioAux);
    }

    public void deleteById(String id) throws UsuarioNotFoundExcpetion{
        if(!_usuarioRepository.existsById(id)){
            throw new UsuarioNotFoundExcpetion(id);
        }

        _usuarioRepository.deleteById(id);
    }
}
