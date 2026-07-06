package com.example.demo.controller;

import com.example.demo.model.Manutencao;
import com.example.demo.service.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;


@RestController
@RequestMapping("/api/manutencoes")
public class ManutencaoController {
    
    @Autowired
    private ManutencaoService manutencaoService;

    @GetMapping
    public List<Manutencao> listarTodos() {
        return manutencaoService.listarTodas();
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Manutencao manutencao) {
        try { Manutencao manutencaoSalva = manutencaoService.salvar(manutencao);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaManutencao);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        manutencaoService.delete(id);
        return ResponseEntity.noContent().build();

    }



}
