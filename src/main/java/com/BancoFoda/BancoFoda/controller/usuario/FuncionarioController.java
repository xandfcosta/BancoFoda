package com.BancoFoda.BancoFoda.controller.usuario;

import com.BancoFoda.BancoFoda.model.domain.usuario.Funcionario;
import com.BancoFoda.BancoFoda.model.service.usuario.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController
{
    @Autowired
    private FuncionarioService _funcionarioService;

    @PostMapping
    public Funcionario save( @Valid @RequestBody Funcionario funcionario){
        return _funcionarioService.save(funcionario);
    }
    
    @GetMapping("/list")
    public List<Funcionario> list(){
        return _funcionarioService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> show( @PathVariable String id){
        Funcionario funcionario = _funcionarioService.getById(id);

        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable String id, @Valid @RequestBody Funcionario funcionario){
        return new ResponseEntity<Funcionario>(_funcionarioService.update(id, funcionario),
                HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> delete(@PathVariable String id) {
        _funcionarioService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
