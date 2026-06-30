package com.example.demo.repository;

import com.example.demo.model.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ManutencaoRepository extends JpaRepository<Manutencao, Long> {
    
}
