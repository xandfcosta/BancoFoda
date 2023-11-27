package com.BancoFoda.BancoFoda.controller;

import com.BancoFoda.BancoFoda.model.domain.Transferencia;
import com.BancoFoda.BancoFoda.model.service.TransferenciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController
{
    private final TransferenciaService _transferenciaService;

    public TransferenciaController( TransferenciaService transferenciaService){
        _transferenciaService = transferenciaService;
    }

    @PostMapping("/save")
    public Transferencia save( @Valid @RequestBody Transferencia transferencia){
        return _transferenciaService.save(transferencia);
    }
    
    @GetMapping("/list")
    public List<Transferencia> list(){
        return _transferenciaService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity show( @PathVariable String id){
        Transferencia transferencia = _transferenciaService.getById(id);

        return new ResponseEntity<Transferencia>(transferencia, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @Valid @RequestBody Transferencia transferencia){
        return new ResponseEntity<Transferencia>(_transferenciaService.update(id, transferencia),
                HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        _transferenciaService.deleteById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
