package com.BancoFoda.BancoFoda.controller.usuario;

import com.BancoFoda.BancoFoda.model.domain.usuario.Cliente;
import com.BancoFoda.BancoFoda.model.dtos.usuario.ClienteDTO;
import com.BancoFoda.BancoFoda.model.service.usuario.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController
{
    @Autowired
    private ClienteService _clienteService;

    @PostMapping
    public Cliente save( @Valid @RequestBody ClienteDTO cliente){ return _clienteService.save(cliente); }

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
    
    @DeleteMapping
    public ResponseEntity<Cliente> delete(@RequestParam String cpf) {
        _clienteService.deleteById(cpf);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
