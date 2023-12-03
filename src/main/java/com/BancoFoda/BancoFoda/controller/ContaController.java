package com.BancoFoda.BancoFoda.controller;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.BancoFoda.BancoFoda.model.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/conta")
public class ContaController
{
    private final ContaService _contaService;

    public ContaController(ContaService contaService){
        _contaService = contaService;
    }

    @PostMapping
    public Conta save( @Valid @RequestBody Conta conta){
        return _contaService.save(conta);
    }
    
    @GetMapping("/list")
    public List<Conta> list(){
        return _contaService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> show( @PathVariable int id){
        Conta conta = _contaService.findById(id);

        return new ResponseEntity<>( conta, HttpStatus.OK );
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Conta> update(@PathVariable int id, @Valid @RequestBody Conta conta){
        return new ResponseEntity<>( _contaService.update( id, conta ),
                HttpStatus.OK );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Conta> delete(@PathVariable int id) {
        _contaService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(name = "/filtrar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Conta> filtrar(@RequestParam Map<String, String> params)
    {
        return _contaService.filtrar( params );
    }
}
