package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.ManutencaoRepository;
import com.example.demo.repository.VeiculoRepository;
import com.example.demo.model.Manutencao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//import java.util.Optional;

@Service
public class ManutencaoService {
    @Autowired
    private ManutencaoRepository manutencaoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Manutencao> listarTodas() {
        return manutencaoRepository.findAll();
    }

    public Manutencao salvar(Manutencao manutencao) {
        if (manutencao.getVeiculo() == null || manutencao.getVeiculo().getId() == null) {
            throw new IllegalArgumentException("O veículo informado para a manutenção não pode ser nulo.");
        }

        boolean veiculoExiste = veiculoRepository.existsById(manutencao.getVeiculo().getId());
        if (!veiculoExiste) {
            throw new IllegalArgumentException("O veículo informado para a manutenção não existe.");
        }

        return manutencaoRepository.save(manutencao);
    }

    public void delete(Long id) {
        manutencaoRepository.deleteById(id);
    }
}
