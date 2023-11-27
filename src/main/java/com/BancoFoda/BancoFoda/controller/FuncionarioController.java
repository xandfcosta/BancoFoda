package com.BancoFoda.BancoFoda.controller;

import com.BancoFoda.BancoFoda.model.domain.Funcionario;
import com.BancoFoda.BancoFoda.model.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController
{
    private final FuncionarioService _funcionarioService;

    public FuncionarioController( FuncionarioService funcionarioService){
        _funcionarioService = funcionarioService;
    }

    @PostMapping
    public Funcionario save( @Valid @RequestBody Funcionario funcionario){
        return _funcionarioService.save(funcionario);
    }
    
    @GetMapping
    public List<Funcionario> list(){
        return _funcionarioService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity show( @PathVariable String id){
        Funcionario funcionario = _funcionarioService.getById(id);

        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @Valid @RequestBody Funcionario funcionario){
        return new ResponseEntity<Funcionario>(_funcionarioService.update(id, funcionario),
                HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        _funcionarioService.deleteById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
