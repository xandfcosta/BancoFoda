package com.BancoFoda.BancoFoda.controller.usuario;

import com.BancoFoda.BancoFoda.model.domain.usuario.Cliente;
import com.BancoFoda.BancoFoda.model.service.usuario.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController
{
    private final ClienteService _clienteService;

    public ClienteController( ClienteService clienteService){
        _clienteService = clienteService;
    }

    @PostMapping
    public Cliente save( @Valid @RequestBody Cliente cliente){ return _clienteService.save(cliente); }

    @GetMapping("/list")
    public List<Cliente> list(){
        return _clienteService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> show( @PathVariable String id){
        Cliente cliente = _clienteService.getById(id);

        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable String id, @Valid @RequestBody Cliente cliente){
        return new ResponseEntity<Cliente>(_clienteService.update(id, cliente),
                HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable String id) {
        _clienteService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
