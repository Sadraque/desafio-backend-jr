package com.desafiobackendjr.controller;

import com.desafiobackendjr.domain.Carro;
import com.desafiobackendjr.domain.dto.CarroDTO;
import com.desafiobackendjr.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Carro> save(@Valid @RequestBody CarroDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(carroService.save(dto));
    }

    @PutMapping(value = "{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Carro> update(@Valid @RequestBody CarroDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok(carroService.update(dto, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        carroService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public ResponseEntity<Carro> findById(@PathVariable Long id) {
        return ResponseEntity.ok(carroService.findById(id));
    }

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<Page<Carro>> findAll(Pageable pageable) {
        return ResponseEntity.ok(carroService.findAll(pageable));
    }
}
