package com.BancoFoda.BancoFoda.controller;

import com.BancoFoda.BancoFoda.model.domain.Compra;
import com.BancoFoda.BancoFoda.model.service.CompraService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraController {
    private final CompraService _compraService;

    public CompraController(CompraService _compraService) {
        this._compraService = _compraService;
    }

    @PostMapping("/save")
    public Compra save(@Valid @RequestBody Compra compra){
        return _compraService.save(compra);
    }

    @GetMapping("/list")
    public List<Compra> list(){
        return _compraService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable int id){
        Compra compra = _compraService.getById(id);

        return new ResponseEntity<Compra>(compra, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @Valid @RequestBody Compra conta){
        return new ResponseEntity<Compra>(_compraService.update(id, conta),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        _compraService.deleteById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
