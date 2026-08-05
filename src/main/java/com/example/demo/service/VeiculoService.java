package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.VeiculoRepository;
import com.example.demo.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscarPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo salvar(Veiculo veiculo) {
        if (veiculo.getStatus() == null || veiculo.getStatus().isEmpty()) {
            veiculo.setStatus("Livre");
        }
        return veiculoRepository.save(veiculo);
    }

    public void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }

    public Veiculo atualizar(Long id, Veiculo veiculoAtualizado) {
    if (!veiculoRepository.existsById(id)) {
        throw new IllegalArgumentException("Veículo não encontrado com o ID: " + id);
    }
    veiculoAtualizado.setId(id);
    return veiculoRepository.save(veiculoAtualizado);
}
}
