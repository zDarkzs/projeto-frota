package com.example.demo.controller;

import com.example.demo.model.Peca;
import com.example.demo.service.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.*;


@RestController
@RequestMapping("/api/pecas")
public class PecaController {

    @Autowired
    private PecaService pecaService;


    @GetMapping
    public List<Peca> listarTodas() {
        return pecaService.listarTodas();
    }   

    @GetMapping("/{id}")
    public ResponseEntity<Peca> buscar(@PathVariable Long id) {
        return pecaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Peca peca) {
        try {
            Peca novaPeca = pecaService.salvar(peca);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaPeca);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pecaService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
