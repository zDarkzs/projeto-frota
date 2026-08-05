package com.example.demo.service;

import com.example.demo.repository.PecaRepository;
import com.example.demo.model.Peca;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@Service
public class PecaService {
    
    @Autowired
    private PecaRepository pecaRepository;

    public List<Peca> listarTodas() {
        return pecaRepository.findAll();
    }

    public Peca salvar(Peca peca) {
        if (peca.getNome() == null || peca.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da peça não pode ser nulo ou vazio.");
        }
        return pecaRepository.save(peca);
    }

    public Optional<Peca> buscarPorId(Long id) {
        return pecaRepository.findById(id);
    }

    public void delete(Long id) {
        pecaRepository.deleteById(id);
    }
    
    public Peca atualizar(Long id, Peca pecaAtualizada) {
        if (!pecaRepository.existsById(id)) {
            throw new IllegalArgumentException("Peça não encontrada com o ID: " + id);
        }
        pecaAtualizada.setId(id);
        return pecaRepository.save(pecaAtualizada);
    }
}
