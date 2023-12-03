package com.BancoFoda.BancoFoda.controller.fatura;

import com.BancoFoda.BancoFoda.model.domain.conta.Cartao;
import com.BancoFoda.BancoFoda.model.domain.conta.Fatura;
import com.BancoFoda.BancoFoda.model.service.conta.FaturaService;
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
    
    @GetMapping("/list")
    public List<Fatura> list(){
        return _faturaService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fatura> show( @PathVariable Long id){
        Fatura fatura = _faturaService.findById(id);

        return new ResponseEntity<>( fatura, HttpStatus.OK );
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Fatura> update(@PathVariable Long id, @Valid @RequestBody Fatura fatura){
        return new ResponseEntity<>( _faturaService.update( id, fatura ),
                HttpStatus.OK );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Fatura> delete(@PathVariable Long id) {
        _faturaService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/vencendo")
    public List< Fatura > vencendoHoje()
    {
        return _faturaService.findVencendoHoje();
    }
}
