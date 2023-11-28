package com.BancoFoda.BancoFoda.controller.monetario.pagamento;

import com.BancoFoda.BancoFoda.model.domain.monetario.pagamento.PagamentoDebito;
import com.BancoFoda.BancoFoda.model.service.monetario.pagamento.PagamentoDebitoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento-debito")
public class PagamentoDebitoController
{
    private final PagamentoDebitoService _pagamentoDebitoService;

    public PagamentoDebitoController( PagamentoDebitoService _pagamentoDebitoService) {
        this._pagamentoDebitoService = _pagamentoDebitoService;
    }

    @PostMapping("/save")
    public PagamentoDebito save( @Valid @RequestBody PagamentoDebito pagamentoDebito){
        return _pagamentoDebitoService.save(pagamentoDebito);
    }

    @GetMapping("/list")
    public List< PagamentoDebito > list(){
        return _pagamentoDebitoService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDebito> show(@PathVariable int id){
        PagamentoDebito pagamentoDebito = _pagamentoDebitoService.getById(id);

        return new ResponseEntity< PagamentoDebito >(pagamentoDebito, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoDebito> update(@PathVariable int id, @Valid @RequestBody PagamentoDebito conta){
        return new ResponseEntity< PagamentoDebito >(_pagamentoDebitoService.update(id, conta),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PagamentoDebito> delete(@PathVariable int id) {
        _pagamentoDebitoService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
