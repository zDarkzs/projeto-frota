package com.example.demo.controller;

import com.example.demo.model.Veiculo;
import com.example.demo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
    
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> listarTodos() {
        return veiculoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
        return veiculoService.buscarPorId(id)
                .map(veiculo -> ResponseEntity.ok().body(veiculo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Veiculo> salvar(@RequestBody Veiculo veiculo) {
        Veiculo veiculoSalvo = veiculoService.salvar(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!veiculoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        veiculoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}") 
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        try {
            veiculo.setId(id);
            Veiculo veiculoAtualizado = veiculoService.atualizar(id, veiculo);
            return ResponseEntity.ok(veiculoAtualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
}
}
