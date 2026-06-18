package com.example.demo.repository;

import com.example.demo.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VeiculoRepository extends JpaRepository<Veiculo, Long> {
    
}
