package com.BancoFoda.BancoFoda.controller;

import com.BancoFoda.BancoFoda.model.domain.Fatura;
import com.BancoFoda.BancoFoda.model.service.FaturaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fatura")
public class FaturaController
{
    private final FaturaService _faturaService;

    public FaturaController( FaturaService faturaService){
        _faturaService = faturaService;
    }

    @PostMapping
    public Fatura save( @Valid @RequestBody Fatura fatura){
        return _faturaService.save(fatura);
    }
    
    @GetMapping
    public List<Fatura> list(){
        return _faturaService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity show( @PathVariable int id){
        Fatura fatura = _faturaService.getById(id);

        return new ResponseEntity<Fatura>(fatura, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @Valid @RequestBody Fatura fatura){
        return new ResponseEntity<Fatura>(_faturaService.update(id, fatura),
                HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        _faturaService.deleteById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
