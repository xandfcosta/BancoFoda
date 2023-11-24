package com.BancoFoda.BancoFoda.controller;

import com.BancoFoda.BancoFoda.model.domain.Usuario;
import com.BancoFoda.BancoFoda.model.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController
{
    private final UsuarioService _usuarioService;

    public UsuarioController( UsuarioService usuarioService){
        _usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario save( @Valid @RequestBody Usuario usuario){
        return _usuarioService.save(usuario);
    }
    
    @GetMapping
    public List<Usuario> list(){
        return _usuarioService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity show( @PathVariable String id){
        Usuario usuario = _usuarioService.getById(id);

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @Valid @RequestBody Usuario usuario){
        return new ResponseEntity<Usuario>(_usuarioService.update(id, usuario),
                HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        _usuarioService.deleteById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
