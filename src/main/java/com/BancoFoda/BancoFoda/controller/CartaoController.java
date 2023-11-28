package com.BancoFoda.BancoFoda.controller;

import com.BancoFoda.BancoFoda.model.domain.Cartao;
import com.BancoFoda.BancoFoda.model.domain.Conta;
import com.BancoFoda.BancoFoda.model.service.CartaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartao")
public class CartaoController
{
    private final CartaoService _cartaoService;

    public CartaoController( CartaoService cartaoService){
        _cartaoService = cartaoService;
    }

    @PostMapping("/save")
    public Cartao save( @Valid @RequestBody Cartao cartao){
        return _cartaoService.save(cartao);
    }
    
    @GetMapping("/list")
    public List<Cartao> list(){
        return _cartaoService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity show( @PathVariable String id){
        Cartao cartao = _cartaoService.getById(id);

        return new ResponseEntity<Cartao>(cartao, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @Valid @RequestBody Cartao cartao){
        return new ResponseEntity<Cartao>(_cartaoService.update(id, cartao),
                HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        _cartaoService.deleteById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
