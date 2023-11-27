package com.BancoFoda.BancoFoda.controller;

import com.BancoFoda.BancoFoda.model.domain.Credito;
import com.BancoFoda.BancoFoda.model.service.CreditoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credito")
public class CreditoController
{
    private final CreditoService _creditoService;

    public CreditoController( CreditoService creditoService){
        _creditoService = creditoService;
    }

    @PostMapping("/save")
    public Credito save( @Valid @RequestBody Credito credito){
        return _creditoService.save(credito);
    }
    
    @GetMapping("/list")
    public List<Credito> list(){
        return _creditoService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity show( @PathVariable int id){
        Credito credito = _creditoService.getById(id);

        return new ResponseEntity<Credito>(credito, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @Valid @RequestBody Credito credito){
        return new ResponseEntity<Credito>(_creditoService.update(id, credito),
                HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        _creditoService.deleteById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
