package com.desafiobackendjr.controller;

import com.desafiobackendjr.domain.Cliente;
import com.desafiobackendjr.domain.dto.ClienteDTO;
import com.desafiobackendjr.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Cliente> save(@Valid @RequestBody ClienteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteService.save(dto));
    }

    @PutMapping(value = "{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Cliente> update(@Valid @RequestBody ClienteDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok(clienteService.update(dto, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        clienteService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<Page<Cliente>> findAll(Pageable pageable) {
        return ResponseEntity.ok(clienteService.findAll(pageable));
    }
}
