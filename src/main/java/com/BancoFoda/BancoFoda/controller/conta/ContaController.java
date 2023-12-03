package com.BancoFoda.BancoFoda.controller.conta;

import com.BancoFoda.BancoFoda.model.domain.conta.Conta;
import com.BancoFoda.BancoFoda.model.service.conta.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ContaService _contaService;

    @PostMapping
    public Conta save( @Valid @RequestBody Conta conta){
        return _contaService.save(conta);
    }
    
    @GetMapping("/list")
    public List<Conta> list(){
        return _contaService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> show( @PathVariable Long id){
        Conta conta = _contaService.findById(id);

        return new ResponseEntity<>( conta, HttpStatus.OK );
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Conta> update(@PathVariable Long id, @Valid @RequestBody Conta conta){
        return new ResponseEntity<>( _contaService.update( id, conta ),
                HttpStatus.OK );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Conta> delete(@PathVariable Long id) {
        _contaService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
