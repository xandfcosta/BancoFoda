package com.BancoFoda.BancoFoda.controller.monetario.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Deposito;
import com.BancoFoda.BancoFoda.model.service.monetario.movimentacao.DepositoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deposito")
public class DepositoController
{
    private final DepositoService _depositoService;

    public DepositoController( DepositoService depositoService){
        _depositoService = depositoService;
    }

    @PostMapping("/save")
    public Deposito save( @Valid @RequestBody Deposito deposito){
        return _depositoService.save(deposito);
    }
    
    @GetMapping("/list")
    public List<Deposito> list(){
        return _depositoService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deposito> show( @PathVariable int id){
        Deposito deposito = _depositoService.getById(id);

        return new ResponseEntity<Deposito>(deposito, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Deposito> update(@PathVariable int id, @Valid @RequestBody Deposito deposito){
        return new ResponseEntity<Deposito>(_depositoService.update(id, deposito),
                HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Deposito> delete(@PathVariable int id) {
        _depositoService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
