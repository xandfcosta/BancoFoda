package com.BancoFoda.BancoFoda.controller.monetario.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Saque;
import com.BancoFoda.BancoFoda.model.service.monetario.movimentacao.SaqueService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saque")
public class SaqueController
{
    private final SaqueService _saqueService;

    public SaqueController( SaqueService saqueService){
        _saqueService = saqueService;
    }

    @PostMapping
    public Saque save( @Valid @RequestBody Saque saque){
        return _saqueService.save(saque);
    }
    
    @GetMapping("/list")
    public List<Saque> list(){
        return _saqueService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Saque> show( @PathVariable int id){
        Saque saque = _saqueService.getById(id);

        return new ResponseEntity<Saque>(saque, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Saque> update(@PathVariable int id, @Valid @RequestBody Saque saque){
        return new ResponseEntity<Saque>(_saqueService.update(id, saque),
                HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Saque> delete(@PathVariable int id) {
        _saqueService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
