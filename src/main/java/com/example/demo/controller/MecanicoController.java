package com.example.demo.controller;

import com.example.demo.model.Mecanico;
import com.example.demo.service.MecanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.*;


@RestController
@RequestMapping("/api/mecanicos")
public class MecanicoController {
    
    @Autowired
    private MecanicoService mecanicoService;

    @GetMapping
    public List<Mecanico> listarTodos() {
        return mecanicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mecanico> buscar(@PathVariable Long id) {
        return mecanicoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Mecanico mecanico) {
        try {
            Mecanico novoMecanico = mecanicoService.salvar(mecanico);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoMecanico);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        mecanicoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Mecanico mecanico) {
        try {
            Mecanico atualizado = mecanicoService.atualizar(id, mecanico);
            return ResponseEntity.ok(atualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
