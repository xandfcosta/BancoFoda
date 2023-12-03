package com.BancoFoda.BancoFoda.controller.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.movimentacao.Transferencia;
import com.BancoFoda.BancoFoda.model.dtos.movimentacao.TransferenciaDTO;
import com.BancoFoda.BancoFoda.model.service.movimentacao.TransferenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController
{
    @Autowired
    private TransferenciaService _transferenciaService;

    @PostMapping
    public Transferencia save( @Valid @RequestBody TransferenciaDTO transferencia){
        return _transferenciaService.save(transferencia);
    }
    
    @GetMapping("/list")
    public List<Transferencia> list(){
        return _transferenciaService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transferencia> show( @PathVariable int id){
        Transferencia transferencia = _transferenciaService.getById(id);

        return new ResponseEntity<Transferencia>(transferencia, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Transferencia> update(@PathVariable int id, @Valid @RequestBody Transferencia transferencia){
        return new ResponseEntity<Transferencia>(_transferenciaService.update(id, transferencia),
                HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Transferencia> delete(@PathVariable int id) {
        _transferenciaService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
