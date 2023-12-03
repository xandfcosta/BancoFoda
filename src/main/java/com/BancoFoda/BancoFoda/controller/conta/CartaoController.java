package com.BancoFoda.BancoFoda.controller.conta;

import com.BancoFoda.BancoFoda.model.domain.conta.Cartao;
import com.BancoFoda.BancoFoda.model.service.conta.CartaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartao")
public class CartaoController
{
    @Autowired
    private  CartaoService _cartaoService;

    @PostMapping
    public Cartao save( @Valid @RequestBody Cartao cartao){
        return _cartaoService.save(cartao);
    }
    
    @GetMapping("/list")
    public List<Cartao> list(){
        return _cartaoService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cartao> show( @PathVariable Long id){
        Cartao cartao = _cartaoService.findById(id);

        return new ResponseEntity<>( cartao, HttpStatus.OK );
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cartao> update(@PathVariable Long id, @Valid @RequestBody Cartao cartao){
        return new ResponseEntity<>( _cartaoService.update( id, cartao ),
                HttpStatus.OK );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Cartao> delete(@PathVariable Long id) {
        _cartaoService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/vencendo")
    public List<Cartao> vencendoHoje()
    {
        return _cartaoService.findVencendoHoje();
    }
}
