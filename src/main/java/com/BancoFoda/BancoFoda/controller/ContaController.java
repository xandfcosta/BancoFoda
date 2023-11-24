package com.BancoFoda.BancoFoda.controller;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.BancoFoda.BancoFoda.model.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

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
    
    @GetMapping
    public List<Conta> list(){
        return _contaService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity show( @PathVariable int id){
        Conta conta = _contaService.getById(id);

        return new ResponseEntity<Conta>(conta, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @Valid @RequestBody Conta conta){
        return new ResponseEntity<Conta>(_contaService.update(id, conta),
                HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        _contaService.deleteById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
