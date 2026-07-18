package com.example.demo.service;

import com.example.demo.repository.MecanicoRepository;
import com.example.demo.model.Mecanico;
import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MecanicoService {
    
    @Autowired
    private MecanicoRepository mecanicoRepository;

    public List<Mecanico> listarTodos() {
        return mecanicoRepository.findAll();
    }

    public Mecanico salvar(Mecanico mecanico) {
        if (mecanico.getNome() == null || mecanico.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do mecânico não pode ser nulo ou vazio.");
        }
        return mecanicoRepository.save(mecanico);
    }

    public Optional<Mecanico> buscarPorId(Long id) {
        return mecanicoRepository.findById(id);
    }

    public void delete(Long id) {
        mecanicoRepository.deleteById(id);
    }
}
